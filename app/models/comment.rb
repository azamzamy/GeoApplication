class Comment < ActiveRecord::Base
    belongs_to :user, dependant: :destroy
  belongs_to :photo, dependant: :destroy
end
