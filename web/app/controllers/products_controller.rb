class ProductsController < ApplicationController
  before_action :authenticate_user!, only: [:checkout, :buy]
  
  def index
    @products = Product.all
  end
  
  def show
    @product = Product.find(params[:id])
  end
  
  def new
    @product = Product.new
  end
  
  def create
    @product = Product.create(product_params)
    
    redirect_to @product
  end
  
  def edit
    @product = Product.find(params[:id])
  end
  
  def update
    @product = Product.find(params[:id])
    @product.update(product_params)
    
    redirect_to @product
  end
  
  def destroy
    @product = Product.find(params[:id])
    @product.destroy
    
    redirect_to products_path
  end
  
  def checkout
    @product = Product.find(params[:id])
  end
  
  def buy
    @product = Product.find(params[:id])
    @product.buy_by(current_user)
    
    redirect_to @product, notice: "You purchased #{@product.name} ya kotch"
  end
  
protected
  
  def product_params
    params.require(:product).permit(:name, :price, :image_url, :stock)
  end
end
