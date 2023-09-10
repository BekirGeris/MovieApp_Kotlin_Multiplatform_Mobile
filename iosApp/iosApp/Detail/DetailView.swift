//
//  DetailView.swift
//  iosApp
//
//  Created by Bekir Geriş on 10.09.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct DetailView: View {
    let movie: Movie
    
    var body: some View {
        ScrollView{
            
            VStack{
                
                ZStack{
                    AsyncImage(url: URL(string: movie.imageUrl)){image in
                        image.resizable().scaledToFill()
                    }placeholder: {
                        ProgressView()
                    }
                }
                .frame(maxWidth: .infinity, minHeight: 300, maxHeight: 300)
                
                VStack(alignment:.leading, spacing: 12){
                    Text(movie.title)
                        .font(.title)
                        .fontWeight(.bold)
                        .fixedSize(horizontal: false, vertical: true)
                        
                    Button(action: {}){
                        HStack{
                            Image(systemName: "play.fill")
                                .foregroundColor(.black)
                            
                            Text("Start watching now")
                                .foregroundColor(.black)
                        }
                    }
                    .frame(maxWidth: .infinity, maxHeight: 40)
                    .padding()
                    .background(.red)
                    .clipShape(RoundedRectangle(cornerRadius: 8))
                    
                    Text("Released in \(movie.releaseDate)".uppercased())
                    
                    Text(movie.description_)
                        .font(.body)
                        .fixedSize(horizontal: false, vertical: true)
                    
                }
                .padding(20)
                .background(.black)
                
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            
        }
    }
}

struct DetailView_Previews: PreviewProvider {
    static var previews: some View {
        DetailView(movie: Movie(id: 1213, title: "String", description: "String", imageUrl: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKq02M8J6GkfINsv1MIw85D2jFT0663SM9Iw&usqp=CAU", releaseDate: "String"))
    }
}
