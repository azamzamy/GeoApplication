class CommentController < ApplicationController
	def create
  @photo = Photo.find(params[:photo_id])
  @comment = @photo.comments.create(comment_params)
  #@comment.user_id = current_user.id 
  #comment_attr = params[:comment].merge :user_id => current_user.id
  if @comment.save
  	flash[:success] = "Comment created!"
    redirect_to @photo #orcomment.photo
  else
    flash.now[:danger] = "error"
  end
end

#def destroy
    #@comment = Comment.find(params[:id])
    #@comment.destroy

 # end

 #deletecomment
 def destroy
  @photo = Photo.find(params[:photo_id])
  @comment = @photo.comments.find(params[:id])
  @comment.destroy

  redirect_to photo_path(@photo)
end
#editcomment
def edit
    @photo = Photo.find(params[:photo_id])
    @comment = @photo.comments.find(params[:id])
  end

   def update
    @photo = Photo.find(params[:photo_id])
    @comment = @photo.comments.find(params[:id])

    if @comment.update(comments_params)
      redirect_to photo_path(@photo,@comment)
   # else
    #  render 'edit'   #view
    end
  end
#viewcomment
def show
    @comment = Comment.find(params[:id])
  end

  def new
    @comment = Comment.new
  end
end
