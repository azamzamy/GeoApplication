class Api::CommentController < Api::BaseController
	before_action :authenticate_user!

	def index
	    respond_with @comments = Comment.all
	end
	
end