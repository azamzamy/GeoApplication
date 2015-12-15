class Api::PhotosController < Api::BaseController
	before_action :authenticate_user!, only: :index

	def index
	    respond_with @photo = Photo.all
	end
	
	def LocationBased
		respond_with @photo = Photo.all
	end
end