import React, { useState } from 'react'
import { createuser } from '../services/UserService'
import { useNavigate } from 'react-router-dom';

const NewUsercomponent = () => {
   const [firstname,setfirstname] = useState('')
   const [lastname,setlastname] = useState('')
   const [email,setemail] = useState('')
   const navigator=useNavigate();
   function handlefirstname(e) {
    setfirstname(e.target.value);
   }
   function handlelastname(e){
    setlastname(e.target.value);
   }
   function handleemail(e){
    setemail(e.target.value);
   }
   function saveuser(e){
    e.preventDefault();
    const user={firstname,lastname,email};
    console.log(user);
    createuser(user).then((Response) => {
        console.log(Response.data);
        navigator('/employees');
    })
   }
  return (
    <div className='container'>
        <br /><br />
      <div className='row'>
       <div className='card col-md-6 offset-md-3 offset-md-3'></div>
       <h2 className='text-center'>Add user</h2>
       <div className='card-body'>
        <form >
            <div className='form-group mb-2'>
                <label className='form-label'>firstname</label>
                <input type="text" 
                placeholder='Enter first-name'
                name='firstname'
                value={firstname}
                    className='form-control' onChange={handlefirstname}
                    >
                </input>
            </div>
            <div className='form-group mb-2'>
                <label className='form-label'>lastname</label>
                <input type="text" 
                placeholder='Enter last-name'
                name='lastname'
                value={lastname}
                    className='form-control' onChange={handlelastname}
                    >
                </input>
            </div>
            <div className='form-group mb-2'>
                <label className='form-label'>email</label>
                <input type="email" 
                placeholder='Enter email'
                name='email'
                value={email}
                    className='form-control' onChange={handleemail}
                    >
                </input>
            </div>
            <button className='btn btn-success' onClick={saveuser}>Submit</button>
        </form>
       </div>
      </div>
    </div>
  )
}

export default NewUsercomponent