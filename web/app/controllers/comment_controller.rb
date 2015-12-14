class CommentController < ApplicationController
  def index
    @products = Comment.all
  end
  
  def show
    @product = Comment.find(params[:id])
  end
  
  def new
    @product = Comment.new
  end
  
  def create
    @product = Comment.create(product_params)
    redirect_to @product
  end
end
