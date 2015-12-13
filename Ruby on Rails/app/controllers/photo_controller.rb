class PhotoController < ApplicationController

	#forcommentsshow
	def show
  @photo = Photo.find(params[:id])
  @comment = @photo.comments.build
end


  #willcreate a new photo 
  def new
    @phto = Photo.new
  end

 #displayallphotos
 def index
    @photo = Photo.all
  end

  # form for editing post
 # def edit
 # end


def create
    @phto = Photo.new(photo_params)
 
    if @photo.save
      redirect_to @photo, notice: 'Post was successfully created.'
     
    end
  end
 
#updating the photos
#def update
	#end
end
