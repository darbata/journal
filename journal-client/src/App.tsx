import SidebarMenuItem from "./SidebarMenuItem.tsx";
import {Library, PencilLine} from "lucide-react";
import {useState} from "react";
import Content from "./Content.tsx";

const menu = [
    {icon: PencilLine, label: "Write"},
    {icon: Library, label: "Library"},
    // {icon: ChartNoAxesCombined, label: "Trends"}
]

export default function App() {

    const [active, setActive] = useState(menu[0].label);

    return (
        <div className="h-screen w-screen bg-bg flex text-fg">
            <div className="bg-sidebar p-0 w-0 invisible lg:visible lg:py-8 lg:w-1/3 lg:px-16 2xl:visible 2xl:w-1/5">
                <h2 className="font-serif font-semibold text-4xl mb-16">Margin</h2>
                {/* sidebar -> TODO: extract to own */}
                <div className="flex flex-col gap-2">
                    {
                        menu.map(
                            (item) => <SidebarMenuItem
                                icon={item.icon}
                                label={item.label}
                                selected={active == item.label}
                                onClick={() => setActive(item.label)}
                            />)
                    }
                </div>
            </div>

            <div className="py-32 px-8 lg:px-16 w-full h-full min-h-0 flex flex-col">
                <div className="w-full max-w-3xl 2xl:max-w-5xl mx-auto h-full min-h-0 flex flex-col">
                    <Content active={active} />
                </div>
            </div>

        </div>
    )
}