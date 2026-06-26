type WritingPageProps = {
    today: Date
}

export default function WritingPage({today} : WritingPageProps) {

    return (
        <div className="flex flex-col">
            <div
                className="font-sans text-fg-muted text-xl tracking-widest"
            >
                {`${today.toLocaleString('default', {weekday: 'long'}).toLocaleUpperCase()}`} &middot; {`${today.toLocaleString('default', {month: 'long'}).toLocaleUpperCase()} ${today.getDate()}`}
            </div>

            <div>
            </div>
        </div>
    )


}