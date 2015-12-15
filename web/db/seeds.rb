# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

photo = Photo.create( user_id: 1, image_url: "http://cdni.condenast.co.uk/646x430/s_v/swissalps_cnt_24nov09_iStock_b.jpg", latitude: "0.14", longitude: "121.651"  )
photo = Photo.create( user_id: 2, image_url: "http://images.wisegeek.com/sailboat-on-water.jpg", latitude: "33.12", longitude: "23.9011"  )
photo = Photo.create( user_id: 1, image_url: "http://i.telegraph.co.uk/multimedia/archive/02080/ski_2080337b.jpg", latitude: "41.22", longitude: "23.1813"  )
photo = Photo.create( user_id: 1, image_url: "http://www.dreamingofmaldives.com/maldives-photo-gallery/maldives-tropical-beach.jpg", latitude: "31.222", longitude: "58.221"  )
