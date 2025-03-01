import SectionDetail from "./SectionDetail"
import './Section.scss'
import { MdOutlinePlayLesson } from "react-icons/md";
import { post } from "jquery"

const SectionComponent = ({index,section}) => {

    console.log('section :: ',section)

    return (
        <>
        <div id={`accordion${index}`} className={`section-container ${section?.emphasized == true && 'section-emphasize-container'}`}>

        <div className="card">
            <div className="card-header" id={`headingOne-${index}`}>
                <h5 className="mb-0 row justify-content-between">
                    <div className="text-start col-4"><MdOutlinePlayLesson />&nbsp;{section?.title} </div>
                    <div className="col-3 chevron-btn-container shadow-5">
                        <button className="chevron-btn" data-toggle="collapse" data-target={`#collapseOne-${index}`} aria-expanded="true" aria-controls={`collapseOne-${index}`}>
                        </button>
                    </div>
                </h5>
                {section?.emphasized == true && <div className="emphasized-title">* Đã được nhấn mạnh</div>}
            </div>

            <div id={`collapseOne-${index}`} className={`collapse ${section?.emphasized == true && 'show'}`} aria-labelledby={`headingOne-${index}`} data-parent={`#accordion${index}`}>
            <div className="card-body">
                <div className="content-section">{section?.content}
                <hr/>
                </div>
                {
                    section?.posts.map((post, index) => (
                        <div key={index}>
                            <SectionDetail index={index} post = {post} />
                        </div>
                    ))
                }
            </div>
            </div>
        </div>

        </div>
        

        
        </>
    )
}

export default SectionComponent