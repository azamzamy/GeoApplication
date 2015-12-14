class UsersController < ApplicationController
  before_action :authenticate_user!, only: [:show, :history]
  
  def show
    @user = current_user
  end
  
  def new
    @user = User.new
  end
  
  def create
    @user = User.new(user_params)
    
    if @user.save
      redirect_to root_path, notice: 'Registered! Please login'
    else
      render action: :new
    end
  end
  
  def history
    @purchases = current_user.purchases.includes(:product)
  end
  
protected
  
  def user_params
    params.require(:user).permit(:name, :email, :password)
  end
end
