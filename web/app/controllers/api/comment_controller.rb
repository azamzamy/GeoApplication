class Api::CommentController < Api::BaseController
	before_action :authenticate_user!, only: :buy

	def index
	    respond_with @comments = Comment.all
	end
	
end