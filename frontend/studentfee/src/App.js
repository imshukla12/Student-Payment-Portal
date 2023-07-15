import { useState, useEffect } from 'react'

import loginService from './services/login'
import billService from './services/bills'

import Notification from './component/Notification'
import Login from './component/login'
import NavBar from './component/NavBar'
import Bills from './component/Bills'

const App = () => {
    const [ user, setUser ] = useState(null)

    const [ bills, setBills ] = useState([])

  const [ notification, setNotification ] = useState(null)
  const [ notificationType, setNotificationType ] = useState(null)

  const notificationHandler = (message, type) => {
    setNotification(message)
    setNotificationType(type)

    setTimeout(() => {
      setNotificationType(null)
      setNotification(null)
    }, 3000)
  }

  
  const handleLogin = async (credentials) => {
    try {
      const userObject = await loginService.login(credentials)
      setUser(userObject)
      window.localStorage.setItem('loggedInUser', JSON.stringify(userObject))
      
      notificationHandler(`Logged in successfully as ${userObject.firstName}`, 'success')
      setBills([])
    }
    catch (exception) {
      notificationHandler(`Log in failed, check username and password entered`, 'error')
    }
  }
  
  const payBill = async (billObject) => {
    try {
       
      await billService.payBill(billObject)

      if (user) {
        const bills = await billService.getUserBills(user)
        setBills(bills)
      }
      notificationHandler(`Successfully paid the bill`, 'success')
    }
    catch (exception) {
      notificationHandler(`Failed to pay the bill successfully`, 'error')
    }
  }

  
  useEffect(() => {
      async function fetchData() {
        if (user) {
          const bills = await billService.getUserBills(user)
          setBills(bills)
        }
      }
      fetchData()
  }, [user])


  useEffect(() => {
    const loggedInUser = window.localStorage.getItem('loggedInUser')
    if (loggedInUser)
      setUser(JSON.parse(loggedInUser))
  }, [])

  return (
    <div>
      <div className='text-center page-header p-2 regular-text-shadow regular-shadow'>
          <div className='display-4 font-weight-bold' style={{textAlign:"center"}}>
            <h1>Student Payment Portal</h1>
          </div>
      </div>
      
      <Notification notification={notification} type={notificationType} />

      {
        
        user === null && 
        <Login startLogin={handleLogin}/>
      }

      {
        
        user !== null && 
        <NavBar user={user} setUser={setUser}/>
      } 

      {
        user !== null &&
        <Bills
          bills={bills}
          payBill={payBill}
        />
      }
    </div>
  )
}

export default App;