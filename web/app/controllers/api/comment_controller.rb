class Api::CommentController < Api::BaseController
	before_action :authenticate_user!, only: :buy

	def index
		@photo = Photo.find(params[:photo_id])
	    respond_with @comments = @photo.comments.all
	end
#create
def create
  @user = User.find(params[:user_id])
  @photo = @user.photos.find(params[:photo_id])
  @comment = @photo.comments.create(comment_params)
@comment.user_id= @photo.user_id
  if @comment.save
format.json{render json: @comment , status: :created , location: @comment}
else
	format.json{render json: @comment.errors , status: :unprocessable_entity}
  end
end


def destroy
  @photo = Photo.find(params[:photo_id])
   @comment = @photo.comments.find(params[:id])
   @comment.destroy
 render json: {}, status: :no_content
 
end

protected
  def comment_params
    params.require(:comment).permit(:content, :user_id , :photo_id)
end
	
end