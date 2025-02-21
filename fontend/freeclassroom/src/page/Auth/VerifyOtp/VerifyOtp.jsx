import { useState } from "react";
import "./VerifyOtp.scss";
import OtpInput from 'react-otp-input';
// import "../../../../node_modules/react-otp-input/example/src/index.css"


const VerifyOTP = () => {

    const [otp, setOtp] = useState('');
    

    return <div className="verify-otp-container row">

        <div className="col align-self-center">

            <div className="card text-center form-otp">
                <div className="card-header">Featured</div>
                <div className="card-body">
                    <h5 className="card-title">Special title treatment</h5>
                    <p className="card-text">With supporting text below as a natural lead-in to additional content.</p>


                    <div className="verify-otp-input">
                        <OtpInput
                        value={otp}
                        onChange={setOtp}
                        numInputs={5}
                        renderSeparator={<span>-</span>}
                        renderInput={(props) => <input {...props} />}
                        />
                    </div>

                    <a href="#" className="btn btn-primary" data-mdb-ripple-init>Go somewhere</a>
                </div>
                <div className="card-footer text-muted">2 days ago</div>
            </div>


        </div>
    
    </div>
}

export default VerifyOTP