import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import AddItem from './AddItem';
import Container from '@mui/material/Container'
import { AppBar, IconButton, List, ListItem, ListItemText, Stack, Toolbar, Typography, makeStyles } from '@mui/material';

function App() {
  
  const[items, setItems] = useState([]);
  const addItem = (item) =>{
    setItems([item, ...items]); //스프레드 표기법
  }

  const removeItem = (index)=>{
    const newItem = [...items];
    newItem.splice(index,1);
    setItems(newItem);
  }

  return (
    <Container>
      <AppBar position='static'>
        <Toolbar>
          <Typography variant='16'>
            Shopping List
          </Typography>
        </Toolbar>
      </AppBar>
      <Stack alignItems="center">
        <AddItem addItem={addItem}/>
        <List>
          {
            items.map((item,index)=>(
              <ListItem key={index}>
                <ListItemText primary={item.product} secondary={item.amount}/>
                <IconButton style={{fontSize:'9px'}} onClick={()=>removeItem}>삭제</IconButton>
              </ListItem>
            ))
          }
        </List>
      </Stack>
    </Container>
  )
}

export default App
