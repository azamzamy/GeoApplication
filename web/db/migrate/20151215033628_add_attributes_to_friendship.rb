class AddAttributesToFriendship < ActiveRecord::Migration
  def change
    add_column :friendships, :isFriend, :bool
  end
end
