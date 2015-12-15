class Api::UsersController < Api::BaseController
	before_action :authenticate_user! 

	def index
	    respond_with @user = current_user
	end
	def edit
		respond_with @user = current_user
	end	

	def show 
		respond_with @user = User.find(params[:user_id])
	end
end