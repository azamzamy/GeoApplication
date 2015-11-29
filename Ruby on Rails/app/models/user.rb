class User < ActiveRecord::Base
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :trackable, :validatable

         has_many :friendships
has_many :friends, :through => :friendships
has_many :inverse_friendships, :class_name => "Friendship", :foreign_key => "friend_id"
has_many :inverse_friends, :through => :inverse_friendships, :source => :user



	validates :email, :fname,  presence: true
	validates :name, length: { minimum: 2 }
	validate :that_born_on_is_not_in_the_future

	 def that_born_on_is_not_in_the_future
	 	self.errors.add :yob, 'is in the future' 
	 unless self.yob <= Date.today


end