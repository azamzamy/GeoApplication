class Purchase < ActiveRecord::Base
  # Relations
  belongs_to :user
  belongs_to :product
end
