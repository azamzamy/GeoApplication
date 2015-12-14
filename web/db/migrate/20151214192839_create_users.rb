class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :name
      t.string :email, null: false
      t.string :encrypted_password, null: false

      t.string :gender
      t.string :pp
      t.string :city
      t.string :country
      t.integer :yearOfBirth

      t.timestamps
    end
    
    add_index :users, :email, unique: true
  end
end
