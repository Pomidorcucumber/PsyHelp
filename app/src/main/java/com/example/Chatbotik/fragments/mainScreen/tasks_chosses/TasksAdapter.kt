package com.example.Chatbotik.fragments.mainScreen.tasks_chosses

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Chatbotik.activity.TaskActivity
import com.example.Chatbotik.fragments.typesTasksData.AudioTaskData
import com.example.Chatbotik.fragments.typesTasksData.ComplexTaskData
import com.example.Chatbotik.fragments.typesTasksData.DictionaryTaskData
import com.example.Chatbotik.fragments.typesTasksData.GrammarTaskData
import com.example.Chatbotik.fragments.typesTasksData.GrammarTheoryData
import com.example.Chatbotik.fragments.typesTasksData.TextTaskData
import com.example.Chatbotik.fragments.typesTasksData.WritingTaskData
import com.example.chatbotik.R

private val audioTaskData1 = AudioTaskData(
    4, listOf(
        Pair(
            R.raw.planetarium, Pair(
                "What is the most impressive thing in nature?",
                Pair(listOf("Planets", "People", "Stars", "Animals"), "Stars")

            )
        ),
        Pair(
            R.raw.planetarium, Pair(

                "What is the planetarium?",
                Pair(listOf("Large building", "Library", "House", "School"), "Large building")
            )
        ),
        Pair(
            R.raw.planetarium, Pair(
                "What could a planetarium be like?",
                Pair(listOf("Work", "Education", "Sleep", "Relax"), "Education")
            )
        )
    )
)

private val audioTaskData2 = AudioTaskData(
    4, listOf(
        Pair(
            R.raw.cowboy, Pair(
                "When were the Golden years of the cowboys?",
                Pair(listOf("1861", "1860", "1870", "1871"), "1860")

            )
        ),
        Pair(
            R.raw.cowboy, Pair(

                "What is the most dangerous city in America?",
                Pair(listOf("Suin Abaline", "Amanda Kris", "Tom Helton", "Max Self"), "Suin Abaline")
            )
        ),
        Pair(
            R.raw.cowboy, Pair(
                "What did the cowboys do when they came to town?",
                Pair(listOf("Went home", "Went to sleep", "Took out the gun", "Relaxed"), "Took out the gun")
            )
        )
    )
)


private val audioTaskData2ru  = AudioTaskData(
    4, listOf(
        Pair(
            R.raw.earth, Pair(
                "Где находится Париж?",
                Pair(listOf("США", "Англия", "Казахстан", "Париж"), "Париж")

            )
        ),
        Pair(
            R.raw.earth, Pair(

                "Как называется деревня?",
                Pair(listOf("Оймякон", "Победа", "Старинко", "Новгород"), "Оймякон")
            )
        ),
        Pair(
            R.raw.earth, Pair(
                "Как называется магазин в деревне?",
                Pair(listOf("Круть", "Здоровье", "Чудный", "Пробка"), "Чудный")
            )
        )
    )
)

private val audioTaskData3 = AudioTaskData(
    4, listOf(
        Pair(
            R.raw.girl, Pair(
                "Boy's family was...",
                Pair(listOf("Rich", "Poor", "Big", "Small"), "Poor")

            )
        ),
        Pair(
            R.raw.girl, Pair(

                "Where did children play?",
                Pair(listOf("School", "House", "Park", "Garden"), "Garden")
            )
        ),
        Pair(
            R.raw.girl, Pair(
                "What is children's favorite game??",
                Pair(listOf("Hide&&Seek", "Football", "Tennis", "Basketball"), "Tennis")
            )
        )
    )
)
private val audioTaskData3ru = AudioTaskData(
    4, listOf(
        Pair(
            R.raw.maslenica, Pair(
                "В какой день недели катаются на санках?",
                Pair(listOf("Вторник", "Понедельник", "Четверг", "Суббота"), "Четверг")

            )
        ),
        Pair(
            R.raw.maslenica, Pair(

                "Какое настроение у людей?",
                Pair(listOf("Веселое", "Грустное", "Загадочное", "Странное"), "Веселое")
            )
        ),
        Pair(
            R.raw.maslenica, Pair(
                "Что сжигают в праздник?",
                Pair(listOf("Дерево", "Бумагу", "Чучело", "Еду"), "Чучело")
            )
        )
    )
)
private val audioTaskData1ru = AudioTaskData(
    4, listOf(
        Pair(
            R.raw.banya, Pair(
                "В какие дни баню используют чаще всего?",
                Pair(listOf("Суббота", "Понедельник", "Четверг", "Суббота"), "Суббота")

            )
        ),
        Pair(
            R.raw.banya, Pair(

                "Какое настроение у людей?",
                Pair(listOf("Веселое", "Грустное", "Загадочное", "Странное"), "Веселое")
            )
        ),
        Pair(
            R.raw.banya, Pair(
                "Какие веники используют в бане?",
                Pair(listOf("Дубовые", "Берёзовые", "Кленовые", "Пихтовые"), "Берёзовые")
            )
        )
    )
)


private val grammarTaskDataPresent1 = GrammarTaskData(
    3, listOf(
        Pair(Pair("I (to do) morning exercises.", "do"), R.drawable.situation),
        Pair(Pair("She (to sleep) after dinner.", "sleeps"), R.drawable.situation),
        Pair(Pair("They (to drink) tea every day.", "drink"), R.drawable.situation),
        Pair(Pair("He (to work) at a factory.", "works"), R.drawable.situation),
        Pair(Pair("We (to work) part-time.", "work"), R.drawable.situation)
    )
)
private val grammarTaskDataPresent1ru = GrammarTaskData(
    3, listOf(
        Pair(Pair("Я (любить) смотреть телевизор.", "люблю"), R.drawable.situation),
        Pair(Pair("Она (заниматься) спортом.", "занимается"), R.drawable.situation),
        Pair(Pair("Они (пить) чай каждое утро.", "пьют"), R.drawable.situation),
        Pair(Pair("Он (работать) на заводе.", "работает"), R.drawable.situation),
        Pair(Pair("Мы (учиться) в школе.", "учимся"), R.drawable.situation)
    )
)
private val grammarTaskDataPresent2 = GrammarTaskData(
    3, listOf(
        Pair(Pair("Alice (to have) a sister.", "haves"), R.drawable.situation),
        Pair(Pair("Her sister’s name (to be) Ann.", "is"), R.drawable.situation),
        Pair(Pair("Ann (to be) a student.", "is"), R.drawable.situation),
        Pair(Pair("She (to get) up at seven o'clock.", "gets"), R.drawable.situation),
        Pair(Pair("She (to go) to the institute in the morning.", "goes"), R.drawable.situation)
    )
)
private val grammarTaskDataPresent2ru = GrammarTaskData(
    3, listOf(
        Pair(Pair("Он (любить) кушать овощи.", "любит"), R.drawable.situation),
        Pair(Pair("Мы (заниматься) спортом.", "занимаюсь"), R.drawable.situation),
        Pair(Pair("Она (пить) таблетки ежедневно.", "пьет"), R.drawable.situation),
        Pair(Pair("Я (работать) учителем.", "работаю"), R.drawable.situation),
        Pair(Pair("Вы (учиться) в университете.", "учитесь"), R.drawable.situation)
    )
)
private val grammarTaskDataPresent3 = GrammarTaskData(
    3, listOf(
        Pair(
            Pair("My working day (to begin) at six o'clock.", "begins"), R.drawable.situation
        ),
        Pair(
            Pair(
                "I (to get) up, (to switch) on the TV and (to brush) my teeth.",
                "gets, switches"
            ), R.drawable.situation
        ),
        Pair(Pair("It (to take) me about twenty minutes..", "takes"), R.drawable.situation),
        Pair(Pair("I (to have) breakfast at seven o’clock.", "have"), R.drawable.situation),
        Pair(Pair("I (to leave) home at half past seven.", "leaves"), R.drawable.situation)
    )
)
private val grammarTaskDataPresent3ru = GrammarTaskData(
    3, listOf(
        Pair(
            Pair("Мой рабочий день (начинаться) в 8 часов.", "начинается"), R.drawable.situation
        ),
        Pair(
            Pair(
                "Я (выключать) телевизор после того, как (почистить) зубы.",
                "выключаю, почищу"
            ), R.drawable.situation
        ),
        Pair(Pair("Это (занять) 20 минут", "займет"), R.drawable.situation),
        Pair(Pair("Я (предпочитать) горячий завтрак.", "предпочитаю"), R.drawable.situation),
        Pair(Pair("Я (уходить) с дома поздно вечером.", "ухожу"), R.drawable.situation)
    )
)
private val grammarTaskDataPast1 = GrammarTaskData(
    3, listOf(
        Pair(Pair("I (to do) morning exercises.", "did"), R.drawable.situation),
        Pair(Pair("She (to sleep) after dinner.", "slept"), R.drawable.situation),
        Pair(Pair("They (to drink) tea every day.", "drank"), R.drawable.situation),
        Pair(Pair("He (to work) at a factory.", "worked"), R.drawable.situation),
        Pair(Pair("We (to work) part-time.", "worked"), R.drawable.situation)
    )
)
private val grammarTaskDataPast1ru = GrammarTaskData(
    3, listOf(
        Pair(Pair("Я (выполнять) задание вчера вечером.", "выполнил"), R.drawable.situation),
        Pair(Pair("Она (спать) 8 часов в субботу.", "спала"), R.drawable.situation),
        Pair(Pair("Они (пить) чай каждое утро.", "пили"), R.drawable.situation),
        Pair(Pair("Он (работать) 8 часов.", "работал"), R.drawable.situation),
        Pair(Pair("У нас (быть) перерыв.", "был"), R.drawable.situation)
    )
)
private val grammarTaskDataPast2 = GrammarTaskData(
    3, listOf(
        Pair(Pair("Alice (to have) a sister.", "had"), R.drawable.situation),
        Pair(Pair("Her sister’s name (to be) Ann.", "was"), R.drawable.situation),
        Pair(Pair("Ann (to be) a student.", "was"), R.drawable.situation),
        Pair(Pair("She (to get) up at seven o'clock.", "got"), R.drawable.situation),
        Pair(Pair("She (to go) to the institute in the morning.", "went"), R.drawable.situation)
    )
)
private val grammarTaskDataPast2ru = GrammarTaskData(
    3, listOf(
        Pair(Pair(" У Алисы (быть) сестра", "была"), R.drawable.situation),
        Pair(Pair("Его сестру (звать) Аня.", "звали"), R.drawable.situation),
        Pair(Pair("Они (смеяться) над ним.", "смеялись"), R.drawable.situation),
        Pair(Pair("Она (встать) в 12:00.", "встала"), R.drawable.situation),
        Pair(Pair("Я (пропустить) первый урок.", "пропустил"), R.drawable.situation)
    )
)
private val grammarTaskDataFuture1 = GrammarTaskData(
    3, listOf(
        Pair(Pair("I (to do) morning exercises.", "wiil do"), R.drawable.situation),
        Pair(Pair("She (to sleep) after dinner.", "will sleep"), R.drawable.situation),
        Pair(Pair("They (to drink) tea every day.", "will drink"), R.drawable.situation),
        Pair(Pair("He (to work) at a factory.", "will work"), R.drawable.situation),
        Pair(Pair("We (to work) part-time.", "will work"), R.drawable.situation)
    )
)
private val grammarTaskDataFuture1ru = GrammarTaskData(
    3, listOf(
        Pair(Pair("Я (выполнить) задание до понедельника.", "выполню"), R.drawable.situation),
        Pair(Pair("Она (лечь) спать пораньше.", "ляжет"), R.drawable.situation),
        Pair(Pair("Они (пить) чай завтра.", "выпьют"), R.drawable.situation),
        Pair(Pair("Он (быть) работать учителем.", "будет"), R.drawable.situation),
        Pair(Pair("Мы (сбежать) с дома.", "сбежим"), R.drawable.situation)
    )
)
private val grammarTaskDataFuture2 = GrammarTaskData(
    3, listOf(
        Pair(Pair("Alice (to have) a sister.", "will have"), R.drawable.situation),
        Pair(Pair("Her sister’s name (to be) Ann.", "will be"), R.drawable.situation),
        Pair(Pair("Ann (to be) a student.", "will be"), R.drawable.situation),
        Pair(Pair("She (to get) up at seven o'clock.", "will get"), R.drawable.situation),
        Pair(
            Pair("She (to go) to the institute in the morning.", "will go"),
            R.drawable.situation
        )
    )
)
private val grammarTaskDataFuture2ru = GrammarTaskData(
    3, listOf(
        Pair(Pair("У Алисы (быть) сестра", "будет"), R.drawable.situation),
        Pair(Pair("Ребенка (назвать) Анна.", "назовут"), R.drawable.situation),
        Pair(Pair("Он (быть) студентом.", "будет"), R.drawable.situation),
        Pair(Pair("Она (встать) завтра утром.", "встанет"), R.drawable.situation),
        Pair(
            Pair("Она (поступить) в университет.", "поступит"),
            R.drawable.situation
        )
    )
)
private val grammarTaskDataFuture3 = GrammarTaskData(
    3, listOf(
        Pair(
            Pair("My working day (to begin) at six o'clock.", "will begin"),
            R.drawable.situation
        ),
        Pair(
            Pair(
                "I (to get) up, (to switch) on the TV and (to brush) my teeth.",
                "will get, will switch"
            ), R.drawable.situation
        ),
        Pair(Pair("It (to take) me about twenty minutes..", "will take"), R.drawable.situation),
        Pair(
            Pair("I (to have) breakfast at seven o’clock.", "will have"), R.drawable.situation
        ),
        Pair(Pair("I (to leave) home at half past seven.", "will leave"), R.drawable.situation)
    )
)
private val grammarTaskDataFuture3ru = GrammarTaskData(
    3, listOf(
        Pair(
            Pair("Мой рабочий день (начаться) через 2 минуты.", "начнется"),
            R.drawable.situation
        ),
        Pair(
            Pair(
                "Я (почистить) зубы, а потом (выключить) телевизор.",
                "почищу, выключу"
            ), R.drawable.situation
        ),
        Pair(Pair("Это (занять) 5 минут.", "займет"), R.drawable.situation),
        Pair(
            Pair("У него (быть) завтрак в пятницу.", "будет"), R.drawable.situation
        ),
        Pair(Pair("Я (уехать) домой скоро.", "уеду"), R.drawable.situation)
    )
)

private val grammarTaskDataPast3 = GrammarTaskData(
    3, listOf(
        Pair(
            Pair("My working day (to begin) at six o'clock.", "began"), R.drawable.situation
        ),
        Pair(
            Pair(
                "I (to get) up, (to switch) on the TV and (to brush) my teeth.", "got, switched"
            ), R.drawable.situation
        ),
        Pair(Pair("It (to take) me about twenty minutes..", "took"), R.drawable.situation),
        Pair(Pair("I (to have) breakfast at seven o’clock.", "had"), R.drawable.situation),
        Pair(Pair("I (to leave) home at half past seven.", "left"), R.drawable.situation)
    )
)
private val grammarTaskDataPast3ru = GrammarTaskData(
    3, listOf(
        Pair(
            Pair("Мой рабочий день уже (начаться).", "начался"), R.drawable.situation
        ),
        Pair(
            Pair(
                "Я (почистить) свои зубы, а потом (выключить) телевизор.", "почистил, выключил"
            ), R.drawable.situation
        ),
        Pair(Pair("Это (занять) 2 часа.", "заняло"), R.drawable.situation),
        Pair(Pair("Я (позавтракать) очень поздно.", "позавтракал"), R.drawable.situation),
        Pair(Pair("Она (уехать) домой в 7.", "уехала"), R.drawable.situation)
    )
)

private
val wordsList1 =
    DictionaryTaskData(
        1,
        listOf(
            Pair(
                "Dog",
                "Собака"
            ),
            Pair(
                "Cat",
                "Кошка"
            ),
            Pair(
                "House",
                "Дом"
            ),
            Pair(
                "Girl",
                "Девочка"
            ),
            Pair(
                "Аge",
                "Возраст"
            ),
            Pair(
                "Explain",
                "объяснять"
            ),
            Pair(
                "Key",
                "ключ"
            )
        )
    )

private
val wordsList2 =
    DictionaryTaskData(
        1,
        listOf(
            Pair(
                "Section",
                "Раздел"
            ),
            Pair(
                "Dress",
                "Платье/одеваться"
            ),
            Pair(
                "Cloud",
                "Облако"
            ),
            Pair(
                "Surprise",
                "Сюрприз"
            ),
            Pair(
                "Quiet",
                "Тихо/тихий"
            ),
            Pair(
                "Iron",
                "Железо"
            ),
            Pair(
                "Single",
                "Один"
            )
        )
    )

private
val wordsList3 =
    DictionaryTaskData(
        1,
        listOf(
            Pair(
                "Stone",
                "Камень"
            ),
            Pair(
                "Tiny",
                "Крошечный"
            ),
            Pair(
                "Climb",
                "Подъем/взбираться"
            ),
            Pair(
                "Cool",
                "Крутой/прохладно"
            ),
            Pair(
                "Design",
                "Дизайн"
            ),
            Pair(
                "Flat",
                "Квартира(брит.)/плоский"
            ),
            Pair(
                "Jump",
                "Прыгать"
            )
        )
    )

private val theoryTaskPresent = GrammarTheoryData(
    4, listOf(
        "Что такое Present Simple?\n" + "Это простое настоящее время, обозначающее действие в самом широком смысле этого слова. Одна из самых распространенных и простых форм в английском языке для описания действий.\n" + "Действия могут быть связаны с привычками, хобби, ежедневным событием вроде подъема по утрам или чем-то, что случается регулярно.\n" + "\n" + "Как образуется Present Simple?\n" + "Нет ничего проще, чем поставить глагол в форму Present Simple. Для этого нужно убрать у глагола в инфинитиве частицу «to» и поставить глагол после подлежащего. Это и есть основное правило Present Simple .\n" + "Утверждение:\n" + "I / We / You / They + V\n" + "She / He / It + V + s (es)\n" + "I go to work every day — Я хожу на работу каждый день.\n" + "They usually play tennis every weekend — Они обычно играют в теннис каждые выходные.\n" + "She brings me coffee every morning — Она приносит мне кофе каждое утро.\n" + "It snows in winter — Зимой идет снег.\n" + "ВАЖНО: В Present Simple форма глагола практически всегда совпадает с изначальной. Исключение составляет третье лицо единственного числа (he / she / it) — к нему прибавляется окончание -s:\n" + "I ride — She rides\n" + "I dream — He dreams\n" + "Если глагол оканчивается на -s, -ss, -sh, -ch, -x, -o, то к нему прибавляется окончание -es\n" + "I wish — She wishes\n" + "I teach — She teaches\n" + "Если глагол оканчивается на -y, а ему предшествует согласная, то к нему прибавляется окончание -es, но -y заменяется на -i\n" + "I try — She tries\n" + "I fly — He flies\n" + "Если глагол оканчивается на -y, а ему предшествует гласная, то к нему также прибавляется окончание -s, но -y не меняется.\n" + "I play — She plays\n" + "I stay — He stays\n"
    )
)
private val theoryTaskPresentru = GrammarTheoryData(
    4, listOf(
        "The present tense in Russian refers to actions or states that are happening in the present moment.\n" + "It is used to talk about routines, habits, general truths, and actions happening at the present time.\n" + "To form the present tense, we typically use verb conjugation, which means that the verb changes its ending depending on the subject of the sentence.\n" + "For example:\n" + "\n" + "Он сейчас спит. – He is sleeping now.\n" + "\n" + "Я все ещё готовлю обед. – I am still cooking lunch."
    )
)
private val theoryTaskPast = GrammarTheoryData(
    4, listOf(
        "Past Simple - простое прошедшее время\n" + "Время Past Simple используется для обозначения действия, которое произошло в определенное время в прошлом и время совершения которого уже истекло.\n" + "Для уточнения момента совершения действия в прошлом при использовании времени Past Simple обычно используются такие слова, как: \n" + "five days ago – пять дней назад; last year – в прошлом году; yesterday – вчера; \n" + "Образование Past Simple\n" + "Утвердительные предложения:\n" + "I played  We played.   You played.  You played.  He / she / it played.  They played.\n" + "Вопросительные предложения:\n" + "Did I play?\tDid we play?  Did you play?  Did you play?  Did he / she / it play?\t Did they play?\n" + "Отрицательные предложения:\n" + "I did not play.  We did not play.  You did not play.  You did not play.  He / she / it did not play.  They did not play.\n"
    )
)
private val theoryTaskPastru = GrammarTheoryData(
    4, listOf(
        "The past tense in Russian, like any language, is one of the most important things to learn.\n" + "The past tense allows you tell stories, and discuss events that have already happened.\n" + "Forming the past tense verbs in Russian is actually quite easy.\n" + "In fact it is one of the simplest conjugations to remember in Russian.\n" + "Я знал - I knew (man speaking)\n" +
                "\n" +
                "Я знала - I knew (woman speaking)\n" +
                "\n" +
                "Он знал - He knew\n" +
                "\n" +
                "Она знала - She knew\n" +
                "\n" +
                "Оно знало - It knew"
    )
)
private val theoryTaskFuture = GrammarTheoryData(
    4, listOf(
        "Future Simple - простое будущее время\n" + "    Время Future Simple ссылается на действие, которое совершится в неопределенном или отдаленном будущем.\n" + "    Простое будущее время в английском языке обычно используется с обстоятельствами:\n" + "    next year – в следующем году; in five years – через пять лет; in 2095 – в 2095 году\n" + "\n" + "    Образование Future Simple\n" + "\n" + "    Утвердительные предложения:\n" + "    I will play.  We will play.  You will play.  You will play.  He / she / it will play.  They will play.\n" + "    Вопросительные предложения:\n" + "    Will I play?\tWill we play?  Will you play?  Will you play?  Will he / she / it play?  Will they play?\n" + "    Отрицательные предложения:\n" + "    I will not play.  We will not play.  You will not play.\tYou will not play.  He / she / it will not play.  They will not play.\n"
    )
)
private val theoryTaskFutureru = GrammarTheoryData(
    4, listOf(
        "Russian future tense can have two forms: simple (via adding personal endings to verbs of perfective aspect), and compound (via using the verb “to be” in the future tense + the infinitive)." + "Я сделаю домашнее задание завтра (Future Simple Tense in Russian) =\n" +
                "\n" +
                "I will do (finish) my homework tomorrow (Future Simple Tense in English)"
    )
)
private val textTask1 = TextTaskData(
    1,
    "First, I wake up. Then, I get dressed. I walk to school. I do not ride a bike. I do not ride the bus. I like to go to school. It rains. I do not like rain. I eat lunch. I eat a sandwich and an apple.\n" + "I play outside. I like to play. I read a book. I like to read books. I walk home. I do not like walking home. My mother cooks soup for dinner. The soup is hot. Then, I go to bed. I do not like to go to bed.\n",
    listOf(
        Pair(
            "What happens first?",
            Pair(listOf("Wake up", "Eat lunch", "Get dressed", "Walk to school"), "Wake up")
        ), Pair(
            "What do I like?",
            Pair(listOf("Books", "Rain", "Going to bed", "Walking home"), "Books")
        ), Pair(
            "How do I go to school?", Pair(
                listOf("I walk.", "I drive a car.", "I ride a bike.", "I ride the bus."),
                "I walk."
            )
        ), Pair(
            "What do I eat for dinner?",
            Pair(listOf("Sandwich", "Pie", "Soup", "Apple"), "Soup.")
        ), Pair(
            "What do I not like?",
            Pair(listOf("Soup", "Going to bed", "Playing", "Going to school"), "Going to bed")
        )
    )
)
private val textTask1ru = TextTaskData(
    1,
    "К Виталику пришел его друг Сережа. В банке он увидел рыбку. Сережа достал свисток. Виталик за свисток отдал ему рыбку.\n" +
            "       Дома Сережа радовался. Виталик грустил. Он смотрел на пустую банку. В руках у него был свисток.\n" +
            "       Но свисток его не радовал.",
    listOf(
        Pair(
            "Как звали друга Виталика?",
            Pair(listOf("Александр", "Артем", "Сережа", "Антон"), "Сережа")
        ), Pair(
            "Кто был в банке?",
            Pair(listOf("Рыбка", "Таракан", "Муха", "Камень"), "Рыбка")
        ), Pair(
            "Что достал Сережа?", Pair(
                listOf("Телефон", "Бутылку", "Свисток", "Камень"),
                "Свисток"
            )
        ), Pair(
            "Что сделали ребята?",
            Pair(
                listOf("Скучали", "Обменялись вещами", "Пошли гулять", "Играли"),
                "Обменялись вещами"
            )
        ), Pair(
            "Из-за чего грустил Виталик?",
            Pair(
                listOf(
                    "Из-за пустой банки",
                    "Из-за оценок",
                    "Из-за ссоры с родителями",
                    "Из-за песни"
                ), "Из-за пустой банки"
            )
        )
    )
)
private val textTask2 = TextTaskData(
    1,
    "I come from a strange family. My parents have always believed that we should learn to look after ourselves from an early age. That included holidays. I remember my poor brother went on a canoeing trip on the River Thames with a cousin when they were both just twelve years old. They had a miserable time and have never really recovered from the experience. When I was fifteen, they decided I was old enough to go on holiday with just my best friend. ‘You’re going to hitch-hike to the Lake District with a tent and a backpack; you’re going to camp, up in the mountains, for a week; and then – if you’re still alive – you’re going to hitch-hike back again. ‘So we hitch-hiked for hundreds of kilometres, we camped, we got cold and wet and scared, and couldn’t afford to buy enough food. But, against the odds, we survived.",
    listOf(
        Pair(
            "Canoening was at the River...",
            Pair(listOf("Thames", "Black", "Themez", "Thomas"), "Wake up")
        ), Pair(
            "We walked ... of kilometres",
            Pair(listOf("10", "1000", "100", "50"), "100")
        ), Pair(
            "I come from a ... family", Pair(
                listOf("Funny", "Scary", "Strange", "Sad"),
                "Strange"
            )
        )
    )
)
private val textTask2ru = TextTaskData(
    1,
    "Стоит на лесной опушке берёза. Дятел пробил в коре дырочку. Он напился берёзового сока и улетел. Побежал ручеёк по стволу дерева. Чистые крупные капли сока упали на землю.\n" +
            "Прилетели синицы. Закружились вокруг берёзы бабочки. Пришли и рыжие муравьи.\n" +
            "Всех угостила вкусным соком добрая берёза.",
    listOf(
        Pair(
            "Что стояло на опушке?",
            Pair(listOf("Клен", "Береза", "Дуб", "Сосна"), "Береза")
        ), Pair(
            "Кто пробил дырочку в коре?",
            Pair(listOf("Дятел", "Стрекоза", "Медведь", "Белка"), "Дятел")
        ), Pair(
            "Кто прилетел в конце?", Pair(
                listOf("Дятлы", "Голуби", "Синицы", "Воробьи"),
                "Синицы"
            )
        )
    )
)
private val textTask3 = TextTaskData(
    1,
    "I used to work on cruise ships as a musician. I travelled a lot! I spent the month before the first lockdown in four continents! I used to get up really early, drive to the airport and fly to a port across the world and get on a ship just to get to work! Then I used to spend between three and fourteen days on the ship. The ships were great. The food was excellent, and the staff were brilliant. The ship stopped at fantastic places, and I often used to spend the afternoon at the beach drinking cocktails or sightseeing. But there were disadvantages too. I often didn’t know anyone on the ship. But the passengers all knew me, and they used to talk to me every time I left my cabin. I didn’t have any privacy. Of course, I had to chat to them politely even when I wasn’t in the mood." , listOf(
        Pair(
            "What is the job of author?",
            Pair(listOf("Musician", "Gamer", "Policeman", "Footballer"), "Musician")
        ), Pair(
            "How did the author get to the place?",
            Pair(listOf("Train", "Bus", "Plane", "Car"), "Plane")
        ), Pair(
            "The staff was like ...", Pair(
                listOf("Gold", "Brilliant", "Silver", "Copper"),
                "Brilliant"
            )
        ), Pair(
            "How many days did the trip last?",
            Pair(listOf("14", "13", "3", "4"), "14")
        ), Pair(
            "What was the name of the author's friend?",
            Pair(listOf("Sam", "Jack", "Robert", "Max"), "Max")
        )
    )
)

private val textTask3ru = TextTaskData(
    1,
    "По сырым местам растет сушеница. Ее можно встретить на заболоченных лугах, на низких берегах рек , а также в посевах и на огородах, где сушеница растет в великом изобилии как сорняк. Это мелкая однолетняя травка с сильно ветвистым коротеньким стеблем, одетым многочисленными узкими листьями. Цветы невзрачные ,незаметные, собраны в многочисленные мелкие корзинки. Все растение густо покрыто шелковистым серебристо-белым пухом, вследствие чего оно кажется седым. Цветет сушеница в течение всего лета, растет почти повсюду-в европейской части России, на Кавказе, в Сибири.",
    listOf(
        Pair(
            "Сушеница это ...",
            Pair(listOf("Сорняк", "Еда", "Камень", "Девушка"), "Сорняк")
        ), Pair(
            "Какие листья у сушеницы?",
            Pair(listOf("Большие", "Маленькие", "Широкие", "Узкие"), "Узкие")
        ), Pair(
            "Где растет сушеница?", Pair(
                listOf("Казахстан", "США", "Сибирь", "Италия"),
                "Сибирь"
            )
        )
    )
)

private val writingTask1 = WritingTaskData(6, listOf("Семья"))
private val writingTask2ru = WritingTaskData(6, listOf("Family"))

class TasksAdapter(
    private val tasks: List<Task>,
    private val context: Context
) :
    RecyclerView.Adapter<TasksAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.text_task_name)
        val imageView: ImageView = itemView.findViewById(R.id.image_task_icon)

        private val sharedPreferences =
            context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        private val language = sharedPreferences.getString("language", "Нет сохраненного текста")

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val task = tasks[position]
                    val context = itemView.context
                    val intent = Intent(context, TaskActivity::class.java)
                    val comlexTask = when (position + 1) {
                        1 -> ComplexTaskData(
                            listOf(1),
                            audioTaskData1,
                            wordsList1,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            textTask1,
                            writingTask1
                        )

                        2 -> ComplexTaskData(
                            listOf(1),
                            audioTaskData1,
                            wordsList2,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            textTask1,
                            writingTask1
                        )

                        3 -> ComplexTaskData(
                            listOf(1),
                            audioTaskData1,
                            wordsList3,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            textTask1,
                            writingTask1
                        )

                        4 -> ComplexTaskData(
                            listOf(6, 2),
                            audioTaskData1,
                            wordsList1,
                            if (language == "English") grammarTaskDataPresent1 else grammarTaskDataPresent1ru,
                            if (language == "English") theoryTaskPresent else theoryTaskPresentru,
                            textTask1,
                            writingTask1
                        )

                        5 -> ComplexTaskData(
                            listOf(6, 2),
                            audioTaskData1,
                            wordsList1,
                            if (language == "English") grammarTaskDataPresent2 else grammarTaskDataPresent2ru,
                            if (language == "English") theoryTaskPresent else theoryTaskPresentru,
                            textTask1,
                            writingTask1
                        )

                        6 -> ComplexTaskData(
                            listOf(6, 2),
                            audioTaskData1,
                            wordsList1,
                            if (language == "English") grammarTaskDataPresent3 else grammarTaskDataPresent3ru,
                            if (language == "English") theoryTaskPresent else theoryTaskPresentru,
                            textTask1,
                            writingTask1
                        )

                        7 -> ComplexTaskData(
                            listOf(6, 2),
                            audioTaskData1,
                            wordsList1,
                            if (language == "English") grammarTaskDataPast1 else grammarTaskDataPast1ru,
                            if (language == "English") theoryTaskPast else theoryTaskPastru,
                            textTask1,
                            writingTask1
                        )

                        8 -> ComplexTaskData(
                            listOf(6, 2),
                            audioTaskData1,
                            wordsList1,
                            if (language == "English") grammarTaskDataPast2 else grammarTaskDataPast2ru,
                            if (language == "English") theoryTaskPast else theoryTaskPastru,
                            textTask1,
                            writingTask1
                        )

                        9 -> ComplexTaskData(
                            listOf(6, 2),
                            audioTaskData1,
                            wordsList1,
                            if (language == "English") grammarTaskDataPast3 else grammarTaskDataPast3ru,
                            if (language == "English") theoryTaskPast else theoryTaskPastru,
                            textTask1,
                            writingTask1
                        )

                        10 -> ComplexTaskData(
                            listOf(6, 2),
                            audioTaskData1,
                            wordsList1,
                            if (language == "English") grammarTaskDataFuture1 else grammarTaskDataFuture1ru,
                            if (language == "English") theoryTaskFuture else theoryTaskFutureru,
                            textTask1,
                            writingTask1
                        )

                        11 -> ComplexTaskData(
                            listOf(6, 2),
                            audioTaskData1,
                            wordsList1,
                            if (language == "English") grammarTaskDataFuture2 else grammarTaskDataFuture2ru,
                            if (language == "English") theoryTaskFuture else theoryTaskFutureru,
                            textTask1,
                            writingTask1
                        )

                        12 -> ComplexTaskData(
                            listOf(6, 2),
                            audioTaskData1,
                            wordsList1,
                            if (language == "English") grammarTaskDataFuture3 else grammarTaskDataFuture3ru,
                            if (language == "English") theoryTaskFuture else theoryTaskFutureru,
                            textTask1,
                            writingTask1
                        )

                        13 -> ComplexTaskData(
                            listOf(4),
                            if (language == "English") audioTaskData1 else audioTaskData1ru,
                            wordsList1,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            textTask1,
                            writingTask1
                        )

                        14 -> ComplexTaskData(
                            listOf(4),
                            if (language == "English") audioTaskData2 else audioTaskData2ru,
                            wordsList1,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            textTask1,
                            writingTask1
                        )

                        15 -> ComplexTaskData(
                            listOf(4),
                            if (language == "English") audioTaskData3 else audioTaskData3ru,
                            wordsList1,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            textTask1,
                            writingTask1
                        )

                        16 -> ComplexTaskData(
                            listOf(3),
                            audioTaskData1,
                            wordsList1,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            if (language == "English") textTask1 else textTask1ru,
                            writingTask1
                        )

                        17 -> ComplexTaskData(
                            listOf(3),
                            audioTaskData1,
                            wordsList1,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            if (language == "English") textTask2 else textTask2ru,
                            writingTask1
                        )

                        18 -> ComplexTaskData(
                            listOf(3),
                            audioTaskData1,
                            wordsList1,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            if (language == "English") textTask3 else textTask3ru,
                            writingTask1
                        )

                        19 -> ComplexTaskData(
                            listOf(5),
                            audioTaskData1,
                            wordsList1,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            textTask1,
                            if (language == "English") writingTask1 else writingTask2ru,
                        )

                        else -> ComplexTaskData(
                            listOf(),
                            audioTaskData1,
                            wordsList1,
                            grammarTaskDataPresent1,
                            theoryTaskPresent,
                            textTask1,
                            writingTask1
                        )
                    }
                    intent.putExtra("complex_task_data", comlexTask)
                    context.startActivity(intent)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.titleTextView.text = task.name
        holder.imageView.setImageResource(task.icon)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}
