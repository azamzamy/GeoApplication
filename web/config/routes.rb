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
    resources :users
    resources :photos
    resources :comment, only: :index
    get 'photos/kamolia' => 'photos#LocationBased'
    get 'friends' => 'friends#index'
    get 'friends/:user_id' => 'friends#show'
    get 'friends/:user_id/:friend_id' => 'friends#destroy'
    get 'friends/:user_id/add/:friend_id' => 'friends#addFriend'
  end 
    
  

  
  resources :comment

  
  root 'comment#index'
end
