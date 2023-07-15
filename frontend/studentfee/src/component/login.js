import React, { useState } from 'react'
import { Button, Form, Input } from "antd";
import{
  Row,
  Layout,
  Typography,
  Divider,
  
} from "antd";
import { UserOutlined, LockOutlined } from "@ant-design/icons";

const { Title } = Typography;
const { Header, Content, Footer, Sider } = Layout;

const Login = ({ startLogin }) => {
  
  const [ email, setEmail ] = useState('')
  const [ password, setPassword ] = useState('')

  
  const handleLogin = (event) => {
   
    event.preventDefault()
    const credentials = {
      "email":email, 
      "password":password,
    }

    startLogin(credentials)

    setEmail('')
    setPassword('')
  }

  return (
    <Layout style={{ minHeight: "100%", display:"flex",justifyContent:"center",backgroundColor:"blanchedalmond",backgroundRepeat:'no-repeat',backgroundSize:"cover"}}>
      <Content>
      <div>
      <Row justify="center" align="bottom">
      <Form>
      <Form.Item name="email" rules={[{required: true, message: "Enter Email"},]}>
      <input 
        type='email' 
        placeholder='Email'
        value={email}
        onChange={event => setEmail(event.target.value)}
        id='email'
        required
      />
      </Form.Item>
      <Form.Item name="Password" rule={[{required:true,message: "Enter Password"},]}>
      <input
        type='password'
        placeholder='Password'
        value={password}
        onChange={event => setPassword(event.target.value)}
        id='password'
        required
      />
      </Form.Item>
      <Form.Item>
      <Button type='primary' htmlType='submit' id='login-submit' onClick={(e)=>{
        setEmail(email);
        setPassword(password);
        handleLogin(e)
        }}>LOGIN</Button>
      </Form.Item>
      </Form>
      </Row>
      </div>
      </Content>
      </Layout>
    
  )
  }

  export default Login
