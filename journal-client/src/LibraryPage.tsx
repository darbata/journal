import DailyOverview from "./DailyOverview.tsx";

export type Emotion =
    | "anger"
    | "disgust"
    | "fear"
    | "joy"
    | "neutral"
    | "sadness"
    | "surprise";

export interface BaseEntry {
    id: string;
    authorId: string;
    title: string;
    content: string;
    createdAt: string;
    updatedAt: string;
}

export type Entry =
    | (BaseEntry & {
        analysed: true;
        dominant: Emotion;
        scores: Record<Emotion, number>;
    })
    | (BaseEntry & {
        analysed: false;
        dominant: "none";
        scores: Record<string, never>;
    });

const dto: Entry[] = [
    {
        "id": "93e8cbe4-a5aa-43b0-98f3-a71298f96ee4",
        "authorId": "daz",
        "title": "Title",
        "content": "Interview is in three days and I still freeze on dynamic programming. Worried I'll blank on the spot.",
        "dominant": "fear",
        "scores": {
            "anger": 0.05732350122904738,
            "disgust": 0.07341513047284437,
            "fear": 0.6279362497567793,
            "joy": 0.038297205325178905,
            "neutral": 0.13538369332244116,
            "sadness": 0.023116366990566586,
            "surprise": 0.04452785290314225
        },
        "analysed": true,
        "createdAt": "2026-06-15T06:47:14.146316Z",
        "updatedAt": "2026-06-15T06:47:14.146316Z"
    },
    {
        "id": "b75acad0-e5b6-4118-b244-ca97504ab0fd",
        "authorId": "daz",
        "title": "Title",
        "content": "Interview is in three days and I still freeze on dynamic programming. Worried I'll blank on the spot.",
        "dominant": "fear",
        "scores": {
            "anger": 0.05154209683781518,
            "disgust": 0.015198977247820407,
            "fear": 0.6932280578427871,
            "joy": 0.022369481711390207,
            "neutral": 0.1541207662793146,
            "sadness": 0.051826386417265134,
            "surprise": 0.011714233663607375
        },
        "analysed": true,
        "createdAt": "2026-06-15T23:26:37.291704Z",
        "updatedAt": "2026-06-15T23:26:37.291704Z"
    },
    {
        "id": "f7682fa0-9584-4bb7-8444-7356f3132e31",
        "authorId": "daz",
        "title": "Title",
        "content": "Finally got my Spring Boot service deployed to EKS without a single rollback. Felt amazing watching the pods spin up green.",
        "dominant": "joy",
        "scores": {
            "anger": 0.05565745167926063,
            "disgust": 0.024555842866687654,
            "fear": 0.03363167968318525,
            "joy": 0.7429209491661537,
            "neutral": 0.05844856097811433,
            "sadness": 0.04982983081327431,
            "surprise": 0.03495568481332407
        },
        "analysed": true,
        "createdAt": "2026-06-16T14:51:29.562275Z",
        "updatedAt": "2026-06-16T14:51:29.562275Z"
    },
    {
        "id": "473e67dd-2bf9-41b0-b4a5-788ea7ad7094",
        "authorId": "daz",
        "title": "Title",
        "content": "Did 4 medium array problems and updated my spaced-repetition deck. Routine grind day.",
        "dominant": "neutral",
        "scores": {
            "anger": 0.021550243162202193,
            "disgust": 0.04244782316152399,
            "fear": 0.026624548519579776,
            "joy": 0.026937026407687525,
            "neutral": 0.8015018988487741,
            "sadness": 0.020907866169558274,
            "surprise": 0.060030593730674105
        },
        "analysed": true,
        "createdAt": "2026-06-17T15:05:55.105907Z",
        "updatedAt": "2026-06-17T15:05:55.105907Z"
    },
    {
        "id": "1bad39fe-9b70-4d10-9426-580e9da8d698",
        "authorId": "daz",
        "title": "Title",
        "content": "Did 4 medium array problems and updated my spaced-repetition deck. Routine grind day.",
        "dominant": "neutral",
        "scores": {
            "anger": 0.01932059704779226,
            "disgust": 0.054413611167524474,
            "fear": 0.041712149824256695,
            "joy": 0.016625742506602,
            "neutral": 0.8140620416661725,
            "sadness": 0.046003538074200566,
            "surprise": 0.007862319713451483
        },
        "analysed": true,
        "createdAt": "2026-06-18T11:34:10.484714Z",
        "updatedAt": "2026-06-18T11:34:10.484714Z"
    },
    {
        "id": "b82e616f-520e-4189-9ec9-3a756162a51a",
        "authorId": "daz",
        "title": "Title",
        "content": "Saw how many people applied to the same internship. Scared I won't even pass the resume screen.",
        "dominant": "fear",
        "scores": {
            "anger": 0.015340846908061612,
            "disgust": 0.029825996446426733,
            "fear": 0.6462930912188467,
            "joy": 0.037084655885154194,
            "neutral": 0.21755711133220465,
            "sadness": 0.011651580224444976,
            "surprise": 0.04224671798486117
        },
        "analysed": true,
        "createdAt": "2026-06-18T16:25:13.957492Z",
        "updatedAt": "2026-06-18T16:25:13.957492Z"
    },
    {
        "id": "d54ede9a-c58e-4a1a-b067-dcf4ea22eb66",
        "authorId": "daz",
        "title": "Title",
        "content": "Mock interview went badly \u2014 I couldn't explain consistent hashing clearly. Panicking a little about the real one.",
        "dominant": "fear",
        "scores": {
            "anger": 0.009782789054783622,
            "disgust": 0.00742649399503861,
            "fear": 0.6156895655881058,
            "joy": 0.038651273713118606,
            "neutral": 0.29253456177447734,
            "sadness": 0.027605806213317288,
            "surprise": 0.008309509661158787
        },
        "analysed": true,
        "createdAt": "2026-06-19T18:23:08.534277Z",
        "updatedAt": "2026-06-19T18:23:08.534277Z"
    },
    {
        "id": "14cd4ecb-7153-48e2-b486-eecb9c95bdb0",
        "authorId": "daz",
        "title": "Title",
        "content": "Worked through two more chapters of DDIA on storage engines. Took notes on LSM-trees vs B-trees.",
        "dominant": "neutral",
        "scores": {
            "anger": 0.05867714344229027,
            "disgust": 0.015632743840062514,
            "fear": 0.07423716450206247,
            "joy": 0.06404840561480263,
            "neutral": 0.7253566808305943,
            "sadness": 0.032799606785388846,
            "surprise": 0.02924825498479895
        },
        "analysed": true,
        "createdAt": "2026-06-19T22:16:55.988210Z",
        "updatedAt": "2026-06-19T22:16:55.988210Z"
    },
    {
        "id": "46ebeffc-89c1-4877-af91-9a2b4f0bb8ef",
        "authorId": "daz",
        "title": "Title",
        "content": "Worked through two more chapters of DDIA on storage engines. Took notes on LSM-trees vs B-trees.",
        "dominant": "neutral",
        "scores": {
            "anger": 0.050337151854038455,
            "disgust": 0.020385273173850284,
            "fear": 0.038212965950691825,
            "joy": 0.03664335046738925,
            "neutral": 0.7767392461082783,
            "sadness": 0.04468222457257383,
            "surprise": 0.032999787873178026
        },
        "analysed": true,
        "createdAt": "2026-06-21T14:32:32.956959Z",
        "updatedAt": "2026-06-21T14:32:32.956959Z"
    },
    {
        "id": "4f97e1ea-8b1a-495c-82df-e11fca35a25a",
        "authorId": "daz",
        "title": "Title",
        "content": "Finally got my Spring Boot service deployed to EKS without a single rollback. Felt amazing watching the pods spin up green.",
        "dominant": "joy",
        "scores": {
            "anger": 0.012822840588763549,
            "disgust": 0.028702281667859757,
            "fear": 0.06805675327322316,
            "joy": 0.5599462185726514,
            "neutral": 0.2678650878411511,
            "sadness": 0.02098055829165374,
            "surprise": 0.04162625976469727
        },
        "analysed": true,
        "createdAt": "2026-06-21T22:58:20.512340Z",
        "updatedAt": "2026-06-21T22:58:20.512340Z"
    },
    {
        "id": "8b7058e2-97f2-4848-b45b-a29bd5688c84",
        "authorId": "daz",
        "title": "Title",
        "content": "The take-home assignment had ambiguous requirements and graded harshly on something they never specified. Annoyed.",
        "dominant": "anger",
        "scores": {
            "anger": 0.6497618858999273,
            "disgust": 0.01181799160062279,
            "fear": 0.02855225763596964,
            "joy": 0.03219501589070075,
            "neutral": 0.19154304278448805,
            "sadness": 0.04707249130068201,
            "surprise": 0.03905731488760949
        },
        "analysed": true,
        "createdAt": "2026-06-21T08:48:08.134628Z",
        "updatedAt": "2026-06-21T08:48:08.134628Z"
    },
    {
        "id": "b7794b54-4999-42d8-b216-a9a623c9f032",
        "authorId": "daz",
        "title": "Title",
        "content": "Refactored my side project's REST layer and added integration tests. Steady, uneventful day.",
        "dominant": "neutral",
        "scores": {
            "anger": 0.02472051038096491,
            "disgust": 0.03360187193733938,
            "fear": 0.05320110562049148,
            "joy": 0.02514483882122103,
            "neutral": 0.7940973077678393,
            "sadness": 0.01268131473531948,
            "surprise": 0.05655305073682441
        },
        "analysed": true,
        "createdAt": "2026-06-22T17:28:28.126882Z",
        "updatedAt": "2026-06-22T17:28:28.126882Z"
    },
    {
        "id": "e8c1e775-80ce-4bfd-b666-9a8916447d8d",
        "authorId": "daz",
        "title": "Title",
        "content": "The take-home assignment had ambiguous requirements and graded harshly on something they never specified. Annoyed.",
        "dominant": "anger",
        "scores": {
            "anger": 0.6607950992218958,
            "disgust": 0.01503761268267178,
            "fear": 0.06914654392504702,
            "joy": 0.04459339960346528,
            "neutral": 0.0909235850128467,
            "sadness": 0.05898128878854415,
            "surprise": 0.06052247076552935
        },
        "analysed": true,
        "createdAt": "2026-06-23T16:04:17.701474Z",
        "updatedAt": "2026-06-23T16:04:17.701474Z"
    },
    {
        "id": "3944d426-639c-439a-a85c-4e23ebb3c75e",
        "authorId": "daz",
        "title": "Title",
        "content": "Compared myself to classmates who already have offers and ended up feeling behind.",
        "dominant": "sadness",
        "scores": {
            "anger": 0.009580031432718641,
            "disgust": 0.04915234625449523,
            "fear": 0.04867191025196249,
            "joy": 0.010005379710497343,
            "neutral": 0.22099491011251995,
            "sadness": 0.6483771355311203,
            "surprise": 0.013218286706685952
        },
        "analysed": true,
        "createdAt": "2026-06-23T19:22:29.905798Z",
        "updatedAt": "2026-06-23T19:22:29.905798Z"
    },
    {
        "id": "58d5f16b-5a4f-461b-8035-d8ef2400f9a8",
        "authorId": "daz",
        "title": "Title",
        "content": "Interview is in three days and I still freeze on dynamic programming. Worried I'll blank on the spot.",
        "dominant": "fear",
        "scores": {
            "anger": 0.021815814939504796,
            "disgust": 0.03890026019115261,
            "fear": 0.6576138140647797,
            "joy": 0.005780245836981575,
            "neutral": 0.1947262981421194,
            "sadness": 0.03786586247366542,
            "surprise": 0.04329770435179641
        },
        "analysed": true,
        "createdAt": "2026-06-23T10:27:29.261941Z",
        "updatedAt": "2026-06-23T10:27:29.261941Z"
    },
    {
        "id": "1c3e600a-8b2d-4b91-b67f-390273c7a637",
        "authorId": "daz",
        "title": "Title",
        "content": "The take-home assignment had ambiguous requirements and graded harshly on something they never specified. Annoyed.",
        "dominant": "anger",
        "scores": {
            "anger": 0.6913019224718969,
            "disgust": 0.01249845928102483,
            "fear": 0.004551671766314161,
            "joy": 0.023541315507065067,
            "neutral": 0.20686318631584377,
            "sadness": 0.04284599160453247,
            "surprise": 0.018397453053322875
        },
        "analysed": true,
        "createdAt": "2026-06-23T11:26:13.906651Z",
        "updatedAt": "2026-06-23T11:26:13.906651Z"
    },
    {
        "id": "1e435ef5-7ff3-4e3d-abe7-d10a2952d86e",
        "authorId": "daz",
        "title": "Title",
        "content": "Interview is in three days and I still freeze on dynamic programming. Worried I'll blank on the spot.",
        "dominant": "fear",
        "scores": {
            "anger": 0.06213543754344296,
            "disgust": 0.010967735993955355,
            "fear": 0.6567268594980077,
            "joy": 0.04397923438610152,
            "neutral": 0.12989868440687355,
            "sadness": 0.018394456914661267,
            "surprise": 0.07789759125695775
        },
        "analysed": true,
        "createdAt": "2026-06-24T21:09:13.061324Z",
        "updatedAt": "2026-06-24T21:09:13.061324Z"
    },
    {
        "id": "1eef8c89-6009-46e0-8f1b-22e164b815e0",
        "authorId": "daz",
        "title": "Title",
        "content": "Set up a local Kubernetes cluster with kind to practice deployments before the interview.",
        "dominant": "neutral",
        "scores": {
            "anger": 0.024412341756724246,
            "disgust": 0.04963421998618813,
            "fear": 0.05143458887487251,
            "joy": 0.03694056043603975,
            "neutral": 0.7188704116151576,
            "sadness": 0.04443953743019426,
            "surprise": 0.07426833990082346
        },
        "analysed": true,
        "createdAt": "2026-06-24T08:43:25.125710Z",
        "updatedAt": "2026-06-24T08:43:25.125710Z"
    },
    {
        "id": "cd20c27e-4adf-4abd-9f7c-ba52cfda0b30",
        "authorId": "daz",
        "title": "Title",
        "content": "Saw how many people applied to the same internship. Scared I won't even pass the resume screen.",
        "dominant": "fear",
        "scores": {
            "anger": 0.02963238006272806,
            "disgust": 0.05513778670600222,
            "fear": 0.6906849818246761,
            "joy": 0.005418189193078203,
            "neutral": 0.17345672587938515,
            "sadness": 0.03535030906594288,
            "surprise": 0.010319627268187323
        },
        "analysed": true,
        "createdAt": "2026-06-24T16:15:08.704318Z",
        "updatedAt": "2026-06-24T16:15:08.704318Z"
    },
    {
        "id": "cea29676-b1fb-47ab-90e3-1982668d5a1a",
        "authorId": "daz",
        "title": "Title",
        "content": "Mock interview went badly \u2014 I couldn't explain consistent hashing clearly. Panicking a little about the real one.",
        "dominant": "fear",
        "scores": {
            "anger": 0.050066194435076976,
            "disgust": 0.04301613029770823,
            "fear": 0.5815344944378559,
            "joy": 0.05837694108161206,
            "neutral": 0.21249513649617063,
            "sadness": 0.0053459404075852385,
            "surprise": 0.04916516284399112
        },
        "analysed": true,
        "createdAt": "2026-06-26T08:56:18.165409Z",
        "updatedAt": "2026-06-26T08:56:18.165409Z"
    },
    {
        "id": "e5ad42c8-1f32-4652-b384-bc693eb14783",
        "authorId": "daz",
        "title": "Title",
        "content": "Pair-programmed with a senior and they said my system design instincts were solid. Big confidence boost.",
        "dominant": "joy",
        "scores": {
            "anger": 0.013820442263444279,
            "disgust": 0.02090624626000839,
            "fear": 0.016916096615025626,
            "joy": 0.5793797527732886,
            "neutral": 0.2825767645115541,
            "sadness": 0.05294769836775976,
            "surprise": 0.033452999208919226
        },
        "analysed": true,
        "createdAt": "2026-06-27T10:16:06.778480Z",
        "updatedAt": "2026-06-27T10:16:06.778480Z"
    },
    {
        "id": "410267b2-3c2b-4578-bf8c-5515b0b314ad",
        "authorId": "daz",
        "title": "Title",
        "content": "Didn't expect the LeetCode contest to go so well \u2014 placed in the top 15%. Genuinely surprised.",
        "dominant": "surprise",
        "scores": {
            "anger": 0.007745040404702341,
            "disgust": 0.07068402596032056,
            "fear": 0.05969590350014976,
            "joy": 0.02893393721434288,
            "neutral": 0.10258756130750572,
            "sadness": 0.05269062862162743,
            "surprise": 0.6776629029913513
        },
        "analysed": true,
        "createdAt": "2026-06-27T07:05:53.290120Z",
        "updatedAt": "2026-06-27T07:05:53.290120Z"
    },
    {
        "id": "d3910981-7287-4b0d-97ca-82a138c80c21",
        "authorId": "daz",
        "title": "Title",
        "content": "Pair-programmed with a senior and they said my system design instincts were solid. Big confidence boost.",
        "dominant": "joy",
        "scores": {
            "anger": 0.016128894379294108,
            "disgust": 0.014735464681118514,
            "fear": 0.02693745610036636,
            "joy": 0.6732900747266396,
            "neutral": 0.13789141162356072,
            "sadness": 0.06421865874059084,
            "surprise": 0.06679803974842985
        },
        "analysed": true,
        "createdAt": "2026-06-27T10:34:23.610805Z",
        "updatedAt": "2026-06-27T10:34:23.610805Z"
    },
    {
        "id": "7e0e4282-e20d-4744-afee-9411ac6b7c95",
        "authorId": "daz",
        "title": "Title",
        "content": "Did 4 medium array problems and updated my spaced-repetition deck. Routine grind day.",
        "dominant": "neutral",
        "scores": {
            "anger": 0.06607883089913374,
            "disgust": 0.05215494104022152,
            "fear": 0.06309537708076247,
            "joy": 0.020333948453833493,
            "neutral": 0.7264236592252216,
            "sadness": 0.05528338209843103,
            "surprise": 0.01662986120239619
        },
        "analysed": true,
        "createdAt": "2026-06-27T09:22:56.917202Z",
        "updatedAt": "2026-06-27T09:22:56.917202Z"
    },
    {
        "id": "bdc51b13-d78d-4dfb-977f-bab1604feffe",
        "authorId": "daz",
        "title": "Title",
        "content": "Refactored my side project's REST layer and added integration tests. Steady, uneventful day.",
        "dominant": "neutral",
        "scores": {
            "anger": 0.022734805771503774,
            "disgust": 0.055819907454769516,
            "fear": 0.012647879230418824,
            "joy": 0.06120893768887073,
            "neutral": 0.7699972540322676,
            "sadness": 0.019914713844906784,
            "surprise": 0.057676501977262755
        },
        "analysed": true,
        "createdAt": "2026-06-28T16:50:51.702448Z",
        "updatedAt": "2026-06-28T16:50:51.702448Z"
    }
]

export default function LibraryPage() {
    const days = new Map<string, Entry[]>();

    dto.forEach((entry) => {
        const key = dayKey(entry.createdAt);
        if (!days.has(key)) days.set(key, []);
        days.get(key)!.push(entry);
    });

    return (
        <div className="flex flex-col gap-12 h-full">
            <span className="text-4xl text-fg font-serif font-semibold">Journal</span>
            <div className="flex-1 min-h-0 overflow-y-auto pr-4">
                {[...days].map(([key, entries]) => (
                    <DailyOverview key={key} date={new Date(key)} entries={entries} />
                ))}
            </div>
        </div>
    );
}

function dayKey(instant: string): string {
    const d = new Date(instant);
    return `${d.getFullYear()}-${d.getMonth()}-${d.getDate()}`;
}