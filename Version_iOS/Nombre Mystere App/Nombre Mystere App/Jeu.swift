//
//  Jeu.swift
//  Nombre Mystere App
//
//  Created by Hadj Rabah on 17/11/2022.
//

import SwiftUI


struct Jeu: View {

    @State public var nombre_mystere: Int = 24
    @State public var user_input: String = "0"
    @State public var text_info: String = ""
    @State public var text_consigne: String = "Entrez un nombre compris entre 0 et 100.\nNombre de tentatives restantes : "
    @State public var user_input_nb: Int = 0
    @State public var disable_text_field: Bool = false
    @State public var disable_boutton_valider: Bool = false
    @State public var compteur: Int = 0
    @State public var n_img: Int = 0
    @State public var nb_chance: Int = 5
    let img_smiley = ["smiley_pense", "smiley_pleure", "smiley_gagne"]

    var body: some View {
        VStack{
            Text("\(text_consigne)").fontWeight(.bold)
            Text("\(nb_chance)").fontWeight(.bold)

            TextField("0", text: $user_input).disabled(disable_text_field)

            
            Button("Valider"){
                nb_chance -= 1
                print("Valider user input : ",user_input)
                print("Nombre de tentative: ",nb_chance)
                user_input_nb = (user_input as NSString).integerValue
                if(user_input_nb == nombre_mystere){
                    text_info = "Bravo, Vous avez trouvé le nombre mystère"
                    text_consigne = "   Fin de la partie\n   Vous avez GAGNÉ"
                    compteur = 1
                    n_img = 2
                    disable_text_field = true
                    disable_boutton_valider = true
                    
                }
                if(user_input_nb < nombre_mystere){
                    print("Le nombre mystère est plus grand")
                    text_info = "Le nombre mystère est plus grand"
                    n_img = 1
                }
                if(user_input_nb > nombre_mystere){
                    print("Le nombre mystère est plus petit")
                    text_info = "Le nombre mystère est plus petit"
                    n_img = 1
                }
                if(nb_chance == 0){
                    if(compteur == 0){
                        print("   Fin de la partie\n   Vous avez PERDU");
                        text_consigne = "   Fin de la partie\n   Vous avez PERDU"
                        disable_text_field = true
                        disable_boutton_valider = true
                    }
                    if(compteur == 1){
                        print("   Fin de la partie\n   Vous avez GAGNÉ ");
                        text_consigne = "   Fin de la partie\n   Vous avez GAGNÉ"
                        disable_text_field = true
                        disable_boutton_valider = true
                    }
                }
                
            }.disabled(disable_boutton_valider)
                .padding()
                .background(Color.blue)
                .cornerRadius(40.0)
                .foregroundColor(.white)
                

            Image(img_smiley[n_img])
                        .resizable()
                        .scaledToFit()
            Text(text_info).fontWeight(.bold)
        }
    }
}

struct Jeu_Previews: PreviewProvider {
    static var previews: some View {
        Jeu()
    }
}
