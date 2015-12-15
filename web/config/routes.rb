Rails.application.routes.draw do

  # Frontend
  resources :sessions, only: [:create, :destroy]
  
  resources :users, except: [:index, :destroy] do
    member do
      get :history
    end
  end

  # API
  namespace :api, defaults: { format: :json } do
    resources :sessions, only: :create
    resources :users do
    resources :photos do
    resources :comment, only: :index
    end
    end

  end
  
  resources :comment

  
  
  root 'comment#index'
end
