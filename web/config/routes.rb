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
    resources :comment, only: :index
    resources :photos
    resources :users
    get 'photos/kamolia' => 'photos#LocationBased'
  end
  
  resources :comment

  
  
  root 'comment#index'
end
