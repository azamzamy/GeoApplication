class Friendship < ActiveRecord::Base

after_initialize do |comment|
    	puts "You now became friends!"
  	end
belongs_to :user
belongs_to :friend, :class_name => "User"
end
