class FixCloumnName < ActiveRecord::Migration
  def self.up
    rename_column :photos, :long, :longitude
    rename_column :photos, :lat, :latitude
  end

end
