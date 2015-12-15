class Api::CommentController < Api::BaseController
	before_action :authenticate_user!, only: :buy

	def index
	    respond_with @comments = Comment.all
	end


	protected
  	def comment_params
    params.require(:comment).permit(:content, :user_id, :photo_id)
	end
	
end