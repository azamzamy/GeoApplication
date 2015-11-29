class Comment < ActiveRecord::Base
  
after_initialize do |comment|
    	puts "You have created an object!"
  	end
    belongs_to :user, dependant: :destroy
  belongs_to :photo, dependant: :destroy
end
