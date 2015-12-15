class Api::FriendsController < Api::BaseController
	before_action :authenticate_user!, only: :buy

	def index
	   respond_with @friends = Friendship.all 
	end

	def show
		@user = User.find(params[:user_id])
		@friends = @user.friends
		
		respond_to do |format| 

      	format.json { render json: @friends.all }
    	end
	end

	def addFriend
		@user = User.find(params[:user_id])
		@friendship = Friendship.new
		@friendship.user_id = @user.user_id
		@friend = User.find(params[:friend_id])
		@friendship.friend_id = @friend.user_id
		@friendship.isFriend = false
		if @friendship.save
		
		respond_to do |format| 

      	format.json { render json: @friendship }
      end
      	else
      	format.json { render json @friendship.errors }
		end
	end
	end

	def acceptFriend
		@friendship = Friendship.where(:user_id=>params[:user_id]).where(:friend_id=>params[:friend_id]).first
		@friendship.isFriend = true
		respond_to do |format| 

      	format.json { render json: @friendship }
    end

    def declineFriend
    	@friendship = Friendship.where(:user_id=>params[:user_id]).where(:friend_id=>params[:friend_id]).first
    	@friendship.destroy
    	head :no_content
    end
	
	def destroy
		@friendship = Friendship.where(:user_id=>params[:user_id]).where(:friend_id=>params[:friend_id]).first
		@friendship.destroy
		head :no_content
	end


	protected
  	def friend_params
    params.require(:friend).permit(:user_id, :friend_id, :isFriend)
	end
	
end