import React from 'react'
import { AppBar, Dialog, DialogActions, DialogContent, DialogTitle, IconButton, List, ListItem, ListItemText, Stack, TextField, Toolbar, Typography, makeStyles } from '@mui/material';
import { useState } from 'react'
import { Button } from '@mui/material';


function AddItem(props) {

    //AddItem component 렌더링시 modal 창을 false를 입력하여 열리지 않도록 한다
    const [open, setOpen] = useState(false);

    //데이터를 수집할 state 선언
    const [item, setItem] = React.useState({
        product:'',
        amount:''
    });

    const handleOpen = () => {
        setOpen(true);
    }

    const handleClose = () =>{
        setOpen(false);
    }

    //onChange 이벤트에 의해서 실행되어 해당 element의 name을 통해서 useState 값을 입력해준다
    const handleChange = (e)=>{
        setItem({...item,[e.target.name]:e.target.value})
    }

    //addItem을 눌렀을 경우 props를 통해서 상위 App.jsx의 addItem에 데이터를 전송하고, 입력 Modal을 초기화 한 후 닫아준다
    const addItem = ()=>{
        props.addItem(item);
        setItem({product:'', amount:''});
        handleClose();
    }

  return (
    <div>
        <Button onClick={handleOpen}>아이템 추가</Button>
        <Dialog open={open} onClose={handleClose}>
            <DialogTitle>새로운 아이템</DialogTitle>
            <DialogContent>
                <TextField value={item.product} margin='dense' onChange={handleChange} name='product'/>
                <TextField value={item.amount} margin='dense' onChange={handleChange} name='amount'/>
            </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>취소</Button>
                    <Button onClick={addItem}>추가</Button>
                </DialogActions>
        </Dialog>
    </div>
  )
}

export default AddItem