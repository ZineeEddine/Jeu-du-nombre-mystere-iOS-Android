//
//  ContentView.swift
//  Nombre Mystere App
//
//  Created by Hadj Rabah on 17/11/2022.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack{
            Text("Jeu du Nombre Mystère").bold()
             
          
            NavigationView{
                  VStack{
                   
                      NavigationLink(destination: Jeu(), label:{
                              Text("Jouer").fontWeight(.bold)
                              .font(.title)
                              .padding()
                              .background(Color.blue)
                              .cornerRadius(40.0)
                              .foregroundColor(.white)
                              .padding(20)
                       })
                    
                    
                    Button(action:{
                        
                        print("Fermeture de l'application")
                        exit(0);
                    }){
                        Text("Quitter").fontWeight(.bold)
                            .font(.title)
                            .padding()
                            .background(Color.blue)
                            .cornerRadius(40.0)
                            .foregroundColor(.white)
                            .padding(20)
                    }
                    
                }
            }
            
        }
        
    }
}
