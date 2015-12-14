class Product < ActiveRecord::Base
  # Methods
  def available?
    self.stock > 0
  end
  
  def buy_by(user)
    if available?
      user.products << self
      
      self.stock -= 1
      save
    end
  end
end
