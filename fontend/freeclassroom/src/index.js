import React from 'react';
import ReactDOM from 'react-dom/client';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import { Provider } from 'react-redux';
import { PersistGate } from 'redux-persist/integration/react';
import { store, persistor } from './redux/store';

import App from './App';
import HomePage from './page/HomePage/Home';
import Login from './page/Auth/Login/Login';
import Register from './page/Auth/Register/Register';
import VerifyOTP from './page/Auth/VerifyOtp/VerifyOtp';
import ClassList from './page/Class/ClassList';
import ClassLayout from './layout/teacher/class/classDetail';
import ClassDetail from './page/Class/ClassDetail/ClassDetail';
import PeopleComponent from './page/Class/ClassDetail/People';

import { ToastContainer } from 'react-toastify';
import reportWebVitals from './reportWebVitals';


const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    children: [
      { index: true, element: <HomePage /> },
      { path: 'login', element: <Login /> },
      { path: 'register', element: <Register /> },
      { path: 'verify-otp', element: <VerifyOTP /> },
      {
        path: 'class',
        element: <ClassLayout />,
        children: [
          { index: true, element: <ClassList /> },
          { path: ':id', element: <ClassDetail /> },
          { path: 'main/:id', element: <ClassDetail /> },
          { path: 'people', element: <PeopleComponent /> },
        ],
      },  
    ],
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <Provider store={store}>
    <PersistGate loading={null} persistor={persistor}>
      <RouterProvider router={router} />
      <ToastContainer />
    </PersistGate>
  </Provider>
);

reportWebVitals();
