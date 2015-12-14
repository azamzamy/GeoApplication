class User < ActiveRecord::Base
  # Fields

  has_many :photos, dependent: :destroy
  attr_accessor :password
  
  # Validations
  validates :name, :email, presence: true
  validates :email, uniqueness: true
  #validates :email, format: { with: /\A.+\..+@student\.guc\.edu\.eg\z/ }
  validates :password, presence: true, on: :create
  
  # Relations
  has_many :purchases, dependent: :destroy
  has_many :products, through: :purchases 
  
  # Callbacks
  before_save :encrypt_password, if: -> { self.password.present? }
  # Callbacks
  before_create -> { self.token = SecureRandom.hex }, unless: :token?
  
  # Class Methods
  def self.authenticate(email, password)
    user = find_by(email: email)
    if user.present? && user.valid_password?(password)
      user
    else
      User.new.tap do |user|
        user.errors.add :base, 'Invalid email or password'
      end
    end
  end
  
  # Methods
  def valid_password?(password)
    self.encrypted_password == Digest::MD5.hexdigest(password)
  end
  
  def encrypt_password
    self.encrypted_password = Digest::MD5.hexdigest(self.password)
  end
end
