import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { Provider } from 'react-redux';
import HomePage from './page/HomePage/Home';
import { ToastContainer} from 'react-toastify';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Login from './page/Auth/Login/Login';
import Register from './page/Auth/Register/Register';
import VerifyOTP from './page/Auth/VerifyOtp/VerifyOtp';
import {store,persistor} from './redux/store';
import { PersistGate } from 'redux-persist/integration/react';
import ClassList from './page/Class/ClassList';
import ClassLayout from './layout/teacher/class/classList/index';
import ClassDetailLayout from './layout/teacher/class/classDetail';
import ClassDetail from './page/Class/ClassDetail/ClassDetail';
import PeopleComponent from './page/Class/ClassDetail/People';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <Provider store={store}>
    <PersistGate loading={null} persistor={persistor}>
    <BrowserRouter>
          <Routes>
            <Route path="/" element={<App />} >
            
              <Route index element={<HomePage />}/>

              <Route path="login" element={<Login />} />

              <Route path="register" element={<Register />} />

              <Route path="verify-otp" element={<VerifyOTP />} />

              <Route path='/class' element= {<ClassLayout/>} > 
                <Route index element={<ClassList />} />
                
                <Route path='class-detail' element={<ClassDetailLayout />}>
                  <Route index element={<ClassDetail />} /> 
                  <Route path='main' element={<ClassDetail />}/>
                  <Route path='people' element={< PeopleComponent/>}/>
                </Route>
              </Route>
              
            </Route>

          </Routes>

          <ToastContainer />

      </BrowserRouter>,
    </PersistGate>
  </Provider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
