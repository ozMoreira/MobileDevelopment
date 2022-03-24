
import { NavigationContainer, } from '@react-navigation/native';
import React, { useState, useEffect }  from 'react';


import { Button, StatusBar, StyleSheet, Text, View, } from 'react-native';

const App = () =>{
  const [count, setCount] = useState(0);
  const msg ='Estou Aqui!'
  console.log('Arrow Function Component', msg)
    
  return(
   
 <View style = { styles.container}>
      <StatusBar style="auto" />

      <Text>Voce clicou {count} vezes!</Text>
      <View style={styles.vBtn}>
      <Button
        onPress={()=> setCount(count +1)}
        title = " + "
      />
        <Button
        onPress={()=> setCount(count -1)}
        title = " - "
      />
      </View>

      <View style={styles.card}>
        <Text>Este é o primeiro card</Text>
      </View>

      <View style={[styles.card,{ backgroundColor: '#ee125a'}]}>
        <Text>Este é o segundo card</Text>
      </View>
      
      <View style={[styles.card,{ backgroundColor: '#91A2AD'}]}>
        <Text>Este é o Terceiro card</Text>
      </View>

    </View>

    )
}
export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
    padding: 16,
  },
  vBtn:{

    flexDirection: 'row',
    marginTop: 25,
    marginBottom: 25,
  },
  card: {
    width: '100%',
    backgroundColor: '#ccc',
    padding: 16,
    borderRadius: 10,
    marginBottom: 8,
  },
});
