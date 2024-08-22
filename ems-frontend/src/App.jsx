import { useState } from 'react'
import './App.css'
import ListUserComponent from './components/ListUserComponent'
import HeaderComponent from './components/HeaderComponent'
import NewUsercomponent from './components/Newusercomponent'
import Pdfdownloadbutton from './components/Pdfdownloadbutton'
import Exceldownloadbutton from './components/Exceldownloadbutton'
import { BrowserRouter,Routes,Route } from 'react-router-dom'

const ExportCSVWrapper = () => {
  const navigate = useNavigate();
  
  useEffect(() => {
    downloadCSV();
    navigate('/employees'); // Redirect to the employees list page or any other page
  }, [navigate]);

  return null;
};

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <BrowserRouter>
    <HeaderComponent/>
    <Routes>
      {/* // http://localhost:3000 */}
    <Route path='/' element={ <ListUserComponent/>}></Route>
    {/* // http://localhost:3000/employees */}
    <Route path='/employees' element={ <ListUserComponent/>}></Route>
    {/* // http://localhost:3000/add-employee */}
    <Route path='/add-employee' element={ <NewUsercomponent/> }></Route>
    <Route path='/employees/export' element={<ExportCSVWrapper />} />
   {/* <Route path='/employees/export' element={<downloadCSV/>} > </Route> */}
   <Route path='/employees/exportpdf' element={Pdfdownloadbutton}></Route>
   <Route path='/employees/exportexcel' element={Exceldownloadbutton}></Route>
    </Routes>

    </BrowserRouter> 

    </>
  )
}

export default App
