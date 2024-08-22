import React ,{useEffect, useState} from 'react'
import { downloadCSV, downloadPdf,downloadExcel,listusers } from '../services/UserService'
import { useNavigate } from 'react-router-dom'


const ListUserComponent = ({ exportCSV }) => {
  const [employees,setEmployees] = useState([])
  const navigator= useNavigate();
  useEffect(() => {
    if (exportCSV) {
      downloadCSV();
    }
  }, [exportCSV]);
  useEffect(() => {
    listusers().then((Response) => {
        setEmployees(Response.data);

    }).catch(error => {
         console.error(error); } )
  },[])

  function addNewuser(){
  navigator('/add-employee');
  }
  
    
  const handleDownload = () => {
    downloadCSV().catch((error) => {
        console.error('Error downloading the file', error);
    });
}
const handleDownloadPdf = () => {
  downloadPdf().catch((error) => {
    console.error('Error downloading the PDF', error);
  });
}
  const handleDownloadexcel = () => {
    downloadExcel().catch((error) => {
      console.error('Error downloading the excel', error);
    });
};

  return (
    <div className='container'>
        <h2 className='text-center'>List of users</h2>
        <button className='btn btn-primary mb-2' onClick={addNewuser} style={{ marginRight: '10px' }}>Add user</button>
<button className='btn btn-primary mb-2' onClick={handleDownload} style={{ marginRight: '10px' }}>Download CSV</button>
<button className='btn btn-primary mb-2' onClick={handleDownloadPdf} style={{ marginRight: '10px' }}>Download PDF</button>
<button className='btn btn-primary mb-2' onClick={handleDownloadexcel}>Download Excel</button>


        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                  <th>user id</th>
                    <th>user firstname</th>
                    <th>user lastname</th>
                    <th>user email-id</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee => 
                        <tr key={employee.id}>
                             <td>{employee.id}</td>
                             <td>{employee.firstname}</td>
                             <td>{employee.lastname}</td>
                             <td>{employee.email}</td>    
                        </tr>
                    )  //to iterate over array and display each element, /* //each row will have unique key */
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListUserComponent