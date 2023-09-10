//
//  MovieGritItem.swift
//  iosApp
//
//  Created by Bekir Geriş on 10.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieGritItem: View {
    
    let movie: Movie
    
    var body: some View {
        VStack(alignment: .leading, spacing: 0) {
            ZStack {
                AsyncImage(url: URL(string: movie.imageUrl)) {
                    image in
                    image.resizable()
                } placeholder: {
                    Color.gray
                }.frame(width: .infinity, height: 200)
                
                Circle()
                    .frame(width: 50, height: 50)
                    .foregroundColor(.black.opacity(0.7))
                
                Image(systemName: "play.fill").foregroundColor(.white)
            }.frame(maxWidth: .infinity)
                .clipShape(RoundedRectangle(cornerRadius: 8))
            
            Text(movie.title)
                .font(.title3)
                .lineLimit(1)
            
            Text(movie.releaseDate)
                .font(.caption)
            
        }.frame(maxWidth: .infinity, maxHeight: 260)
    }
}

struct MovieGritItem_Previews: PreviewProvider {
    static var previews: some View {
        MovieGritItem(movie: Movie(id: 1213, title: "String", description: "String", imageUrl: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKq02M8J6GkfINsv1MIw85D2jFT0663SM9Iw&usqp=CAU", releaseDate: "String"))
    }
}
