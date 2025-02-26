import SectionDetail from "./SectionDetail"
import './Section.scss'

const SectionComponent = () => {
    return (
        <>

        <div id="accordion" className="section-container">

        <div className="card">
            <div className="card-header" id="headingOne">
            <h5 className="mb-0 row justify-content-between">
                <div className="text-start col-4">Overview</div>
                <div className="col-3">
                    <button className="btn btn-primary" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        overview
                    </button>
                </div>
            </h5>
            </div>

            <div id="collapseOne" className="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
            <div className="card-body">
                <SectionDetail/>
                <SectionDetail/>
            </div>
            </div>
        </div>

        </div>
        

        
        </>
    )
}

export default SectionComponent