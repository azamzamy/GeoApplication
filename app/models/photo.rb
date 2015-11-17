class Photo < ActiveRecord::Base
  
    belongs_to :user, dependant :destroy

  has_many :comment
end
