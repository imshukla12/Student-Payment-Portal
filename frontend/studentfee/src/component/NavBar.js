import React from 'react'


const NavBar = ({ user, setUser }) => {
    const logout = () => {
    window.localStorage.removeItem('loggedInUser')
    setUser(null)
  }

  if (!user)
    return null

  return (

    <div className='regular-shadow mb-1'>
      <nav className='navbar navbar-expand-lg navbar-dark' id='menu'>
        <button className='navbar-brand btn btn-link border border-light p-2' style={{color:"black"}}>Welcome {user.firstName} !!</button>
        <div className='collapse navbar-collapse' id='navbarSupportedContent'>
          {/* <ul className="navbar-nav mr-auto">
            <li className="nav-item active"> */}
              {/* Here you can put a Link of React-Router, not of use right now but helpful for the future */}
              {/* Home  */}
            {/* </li>
          </ul> */}
         
          <div className='inline my-2 my-lg-0'><button className='btn btn-primary' onClick={logout}  style={{marginLeft:"95%",color:"crimson"}}>Logout</button></div>
        </div>
      </nav>
    </div>
  )
}

export default NavBar
