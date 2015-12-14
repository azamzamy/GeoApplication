class CreatePhotos < ActiveRecord::Migration
  def change
    create_table :photos do |t|
    	t.references :user, index: true
    	t.string :long
      	t.string :lat
      	t.datetime :upload_date
      	t.string  :image_url
      	t.timestamps null: false
    end
    #add_foreign_key :photos, :users
  end
end
