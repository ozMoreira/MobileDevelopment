import React from 'react';
import { StyleSheet, ScrollView, StatusBar, Text, TextInput, View, Platform, Button } from 'react-native';

export default class App extends React.Component{
  

  //construtor de variaveis 
  constructor(props){
    super(props)
    //definicao de uma variavel de estado
    this.state = {
      mensagem: "",
      nome: "",
    }
  }

  mudouMensagem = msg => {
    //alteracao do valor da variavel de estado
    this.setState({mensagem: msg})
  }

  cliqueBotao = _ =>{
    const { nome } = this.state
    if (!nome){
      alert('Bem vindo','Informe um nome.')
    }
    else {
      alert(`Olá, ${nome}.`)
    }
  }

  render(){
    const { mensagem } = this.state
    return(
     <View style={styles.container}>
      <Text style={[styles.smallText, styles.textStyle]}>Seja bem vindo!</Text>
      <Text style={[styles.largeText, styles.textStyle, styles.red]}>TNT TECH</Text>
      <Text style={[styles.smallText, styles.textStyle]}>Explodindo problemas!</Text>
      <TextInput 
        placeholder='Digite seu nome...'
        style={[styles.medText, styles.inputStyle, styles.paragrafo]}
        onChangeText={nome => this.setState({nome})}
        />
      {/* onChangeText={this.mudouMensagem} */}
      {/*uso da variavel de estado*/}
      {/* <Text 
        style={[styles.smallText, styles.textStyle]}>{mensagem}
      </Text> */}
      
      <Button 
        color= '#000'
        onPress={this.cliqueBotao}
        title={"Processar"}/>
      <StatusBar style='light'/>
     </View>
    );
  }
}



const styles = StyleSheet.create({
  container : {
    flex : 1,
    backgroundColor : '#fff',
    alignItems : 'center',
    justifyContent : 'center',
    padding: 16
  },
  red: {
    color: 'red',
  },
  textStyle:{
    textAlign: 'center',
    ...Platform.select({
      ios: {
        fontFamily: 'AvenirNext-Regular',
      }, android: {
        fontFamily: 'Roboto',
      }
    })
  
  },
  largeText: {
    fontSize: 44,
  },
  medText: {
    fontSize: 25,
  },
  smallText: {
    fontSize: 18,
  },

  paragrafo: {
    marginTop: 80,
    marginBottom: 16
  },

  inputStyle: {
    borderColor: 'gray',
    borderWidth: 1,
    height: 50,
    width: 300,
    padding: 5,
    textAlign: 'center',
    marginBottom: 32,
    marginTop: 32,
    borderRadius : 50
  }
});
