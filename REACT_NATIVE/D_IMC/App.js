import React from 'react';
import {ScrollView, ImageBackground , Button, TextInput, StyleSheet,StatusBar, Text, View } from 'react-native';



export default class App extends React.Component{
  
  constructor(props){
    super(props)
    this.state ={
      altura: "",
      peso: "",      

    }
  }

  calculaIMC = _ =>{
    const { peso } = this.state
    const { altura } = this.state
    let p = parseFloat(peso)
    let a = parseFloat(altura) / 100
    let { imc } = 0
    if (!peso) {
      alert('Favor informar o peso')
     } 
    else if (!altura){
      alert('Favor informar a altura')
      }
    else {
      let altura_pow = a * a
      imc = (p / altura_pow).toFixed(2)

    if (parseFloat(imc) < 18.5){
      alert(`Seu IMC é >>> ${imc} --- Voce está abaixo do peso!`)
    } 
    else if (parseFloat(imc) >= 18.5 && parseFloat(imc) < 25 ){
      alert(`Seu IMC é >>> ${imc} --- Voce está no peso ideal!`)
      } 
    else if (parseFloat(imc) >= 25 && parseFloat(imc) < 30){
      alert(`Seu IMC é >>> ${imc} --- Voce está acima do peso!`)
      } 
    else {
      alert(`Seu IMC é >>> ${imc} ---  Voce está obeso!`)
    }
  }
}
  render(){
    const { peso } = this.state
    const { altura } = this.state
    return (
      <ScrollView contentContainerStyle={{flexGrow: 1}}
        keyboardShouldPersistTaps='handled'>
      <View style={styles.container}>
        <ImageBackground
          source={require('./assets/plano_fundo.jpg')}
          style={styles.imagemBackground} >
            <View style={styles.container}>
              <Text style={[styles.texto, styles.textoGrande]}>Calcule o seu IMC:</Text>
              <Text style={[styles.texto, styles.textoPequeno]}>basta inserir os dados abaixo:</Text>
              <TextInput
              onChangeText={peso => this.setState({peso})}
              placeholder = "Peso"
              placeholderTextColor="#808080"
              keyboardType="numeric"
              maxLength={5}
              style={[styles.textInput, styles.textoPequeno, styles.textInputBig, styles.separadorCampos]}
              />

              <TextInput
              onChangeText={altura => this.setState({altura})}
              placeholder = "Altura"
              placeholderTextColor="#808080"
              keyboardType="numeric"
              maxLength={4}
              style={[styles.textInput, styles.textoPequeno, styles.textInputSmall]}
              />  
                
              </View>
               <View
                style={styles.container2}>
                <Button 
                  color= '#D2B48C'
                  onPress={this.calculaIMC}
                  title={"CALCULAR"}
                  />
        
            </View>
           
            <View style={styles.containter3}>
              
              <Text 
                style={[styles.texto, styles.textoPequeno]}>Seu peso é de: {peso} kg.
              </Text>
              <Text 
                style={[styles.texto, styles.textoPequeno]}>Voce mede: {altura} metros.
              </Text>
            </View>
        </ImageBackground>
        <StatusBar style="auto" />
      </View>
      </ScrollView>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "column",
  },

  container2: {
    flex: 1,
    marginTop: -100,
    flexDirection: "column",
    alignSelf: 'flex-end',
    padding: 20,
    fontWeight: "bold",

  },

  containter3: {
    flex: 1,
    flexDirection: "column",
    justifyContent: "flex-start",
    alignSelf: 'flex-start',
    padding: 20,
    fontWeight: "bold",
    alignItems: "flex-start"
  },

  imagemBackground: {
    flex: 1,
    resizeMode: "cover",
    justifyContent: "flex-start",
    alignItems: "center"
  },
  texto: {
    color: '#D2B48C',
    fontWeight: "bold",
    textAlign: "center"
  },

  textoGrande:{
    fontSize: 42,
    marginTop: 80,
  },

  textoPequeno:{
    fontSize: 22,
  },

  textInput:{
    marginTop: 30,
    padding: 1,
    borderRadius: 100,
    borderColor:'#D2B48C',
    backgroundColor:'#C0C0C0',
    //opacity: 0.8,
    borderWidth: 3,
    height:50,
    paddingHorizontal: 16,
    textAlign: 'center',
    alignSelf: 'flex-end',
    color: '#000'
  },

  separadorCampos:{
    marginTop: 70
  }, 

  textInputBig:{
    width: 300
  },

  textInputSmall:{
    width: 200
  }
  
});
