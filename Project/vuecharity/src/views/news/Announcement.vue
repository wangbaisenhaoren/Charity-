<template>
    <div>
        <div>
            <el-table
                    :data="tableData"
                    height="600"
                    style="width: 100%; margin-top:80px"
                    :default-sort = "{prop: 'date', order: 'descending'}"
                    :row-key="getRowKeys"
                    :expand-row-keys="expands">
                <!--              @current-change="toggleRowExpansion">-->
                <el-table-column type="expand">
                    <template slot-scope="props">
                        <el-form label-position="center" >
                            <el-form-item label="Date">
                                <span>{{ props.row.date }}</span>
                            </el-form-item>
                            <el-form-item label="Title">
                                <span>{{ props.row.title }}</span>
                            </el-form-item>
                            <el-form-item label="">
                                <span>{{ props.row.contents}}</span>
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column
                        label="Date"
                        prop="date">
                </el-table-column>
                <el-table-column
                        label="Title"
                        prop="title">
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>

<style>
    .demo-table-expand {
        font-size: 0;
    }
    .demo-table-expand label {
        width: 90px;
        color: #99a9bf;
    }
    .demo-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 50%;
    }
</style>

<script>
    export default {
        data() {
            return {
                tableData: [{
                    title: 'Give a life-changing donation',
                    date: '2020-01-02',
                    contents:'\n'+
                        'Right now, some of the world’s poorest and most marginalised people don’t have clean water to drink, decent toilets or hygiene. Without these basics, overcoming poverty is just a dream.But when you help us to dig a well or install a tap stand in a community, you\'re changing the lives of children like Dina.\n' +
                        '\n' +
                        'All children should spend their childhood being a child - playing, learning, growing into their full potential. Instead, too many children around the world are walking long distances to collect dirty water. Clean water means improved health, good hygiene, clean clothes, a chance to attend school and to dream. This should be normal.\n' +
                        '\n' +
                        '785 million people in the world – one in ten – do not have clean water close to home. We\'ll keep working until everyone, everywhere has clean water, decent toilets and good hygiene. But we can’t do it without you.',

                }, {
                    title: 'WE HAVE ALL WATCHED IN HORROR AS THE COVID-19 OUTBREAK HAS TURNED LIVES AT HOME AND OVERSEAS UPSIDE DOWN.',
                    date: '2020-04-07',
                    contents: 'Save the Children has launched a fundraising appeal for vulnerable children affected by Coronavirus in the UK and around the world. In the UK, it will fund a series of initiatives to support those children most in need during this unprecedented time of social and economic upheaval. \n' +
                        '\n' +
                        'The charity announced a new emergency grants programme in the UK to respond to the COVID-19 crisis, which aims to reach thousands of struggling families who are feeling the economic effects of the unfolding situation most acutely.\n' +
                        '\n' +
                        'The programme will make sure families have access to early learning resources, as well as goods like tables and beds, to help build home environments in which children can continue learn and thrive. The programme will also support vulnerable families with gifts in kind and food vouchers, to help them make ends meet.\n' +
                        '\n' +
                        'This appeal comes as Save the Children warns that the global coronavirus pandemic threatens to devastate children’s health and education, and cause unprecedented protection needs. In the largest appeal in its 100-year-history, the agency is aiming to raise $100 million, globally, to keep children and their families safe during the global COVID-19 outbreak, the most serious threat to global health and security in modern times.\n' +
                        '\n' +
                        'Some of these funds will go to help families in need in the UK.\n' +
                        '\n' +
                        'Since the start of the outbreak, Save the Children has continued to respond to the needs of communities in countries impacted by the COVID-19 outbreak, including China, the US and across Europe. As the Coronavirus pandemic now accelerates across lower income countries, with new cases expected to reach 10,000 across Africa this week, the agency is warning that failure to act now in countries across south Asia and sub-Saharan Africa could result in the loss of three million people’s lives.\n' +
                        '\n' +
                        'CEO of Save the Children, Kevin Watkins, said: “We have all watched in horror as the COVID-19 outbreak has turned lives at home and overseas upside down. The pandemic is now spreading everywhere, further crippling fragile health systems where children in many countries are already missing out on life saving treatment for malaria, pneumonia and malnutrition. It will leave many children without caregivers, out of school and in danger. We only have a matter of weeks to take swift action, that will determine how many lives we can save.”\n' +
                        '\n' +
                        'With the funds raised, Save the Children will strengthen its work for children so they can withstand the impact of the virus and it will protect the most vulnerable children in countries hardest hit by the virus, especially children living in poverty, refugees, displaced families, communities in conflict and crisis areas and girls. This includes increasing support for national health systems, standing by families facing loss of earnings caused by isolation measures, supporting unaccompanied children, and ensuring children can continue to get an education.\n' +
                        '\n' +
                        'Save the Children warns the youngest generation will be deeply impacted by the outbreak. Already, an estimated 1.5 billion children and students are out of school with their chances of return diminishing each day closures continue. In many of the world’s poorest communities, as poverty deepens, children may be forced to work and adolescent girls forced into early marriage. Unsupervised children are at increased protection risks and, children who face domestic violence and abuse now face prolonged periods at home, whilst access to support services are reduced.\n' +
                        '\n' +
                        'Worldwide, Save the Children works with half a million community health workers in 44 countries to deliver vital health services – the agency aims to support them in recognising symptoms and preventing COVID-19, and to train another 100,000 in the coming six months. It will work with local communities to deliver training and protective equipment so that prevention measures can be ramped up, and cases can be identified early, referred for treatment and where possible, isolated.\n' +
                        '\n' +
                        'Mr Watkins continued: “This crisis will test us like we have not been tested before. As the world shuts down borders and fragile healthcare systems buckle under the pressure of the pandemic, preparedness and efforts to slow the infection rate will mean the difference between life and death. Families may not have access to healthcare, clean water, and may suffer language or literacy barriers. We must ensure they have the support and information they need to protect themselves. This is vital for all, because no one is safe until everyone is safe.”',
                }, {
                    title: 'Coronavirus: how we\'re saving lives',
                    date: '2020-03-15',
                    contents: 'The number of coronavirus cases and deaths in the country continues to rise, with a major impact on NHS resources.\n' +
                        '\n' +
                        'Our charity’s vital role in responding to the needs of communities across the nation has never been more relevant or urgent. St John volunteers are supporting patients right now in the NHS Nightingale Hospital in London, and in hospital emergency departments up and down the country caring for those in need.\n' +
                        '\n' +
                        'As more Nightingale hospitals open, our volunteers stand ready to support them. Our volunteer ambulance crews are also working 24/7 supporting 999 call outs and transporting recovered patients back home safely.\n' +
                        '\n' +
                        'How our volunteers are stepping forward\n' +
                        'Toni takes us through a day of working with the London Ambulance Service. Toni and thousands of other volunteers are supporting the NHS right now, by transporting patients and caring for those in need.',
                }, {
                    title: 'How to keep healthy while you can\'t go out',
                    date: '2020-04-15',
                    contents: 'What should I eat to help my immune system?\n' +
                        'A healthy diet can help keep your immune system working well – so it’s a great time to enjoy eating a range of healthy foods and enjoying making delicious food for yourself. If you need any inspiration, search for tasty recipes on the BHF recipe finder.\n' +
                        '\n' +
                        'If you have food in the cupboard or in the freezer, this is a good time to use it. You will probably be surprised at what’s lurking in the back of your cupboards – those good intention healthy buys, such as pearl barley, lentils and dried fruit. As you might not be used to cooking with some of your ingredients, try starting with the ingredient and then track down the right recipe.\n' +
                        '\n' +
                        'Old oats can become a healthy pudding with our apple and blackberry oat crumble recipe. You can swap the apple and berries for any fresh, frozen or tinned fruit.\n' +
                        'Don’t bin browning bananas, as they could be combined with old flours or brans in your cupboard and make banana bread and muffins.\n' +
                        'Add pulses such as lentils to dishes like Bolognese or chilli con carne, and you’ll add protein and heart-healthy fibre to your diet at the same time. Add them to the minced meat mixture in this recipe and you can use it for either dish. It’s also a good way to use up odd half packets of pasta or rice.\n' +
                        'Tinned fish makes easy pasta sauces and toppings for sandwiches, salads, or jacket potatoes. This tuna and sweetcorn pasta bake uses store cupboard staples, and you can use stale bread for the topping, rather than throwing it away.\n' +
                        'Don’t forget the herbs and spices in your store cupboard. Dried herbs and spices are an easy way to add flavour without adding salt, as eating too much salt can increase your blood pressure and can raise your risk of further heart problems.\n' +
                        'Tins of soup are a delicious meal, just add some noodles, rice, croutons (made from stale bread), or leftover vegetables to make the meal go further. Tinned soups are also a great short cut in recipes – lentil soup can be added to meat sauces, cream of chicken could be part of a pasta bake sauce or broths could be a base for a noodle dish.\n' +
                        'Check out our recipe finder for some classic, easy-to-cook, basic recipes that can be adapted to form the basis of several different dishes.\n' +
                        '\n' +
                        'Our cottage pie filling works just as well on spaghetti or in lasagne, or as a jacket potato topping.\n' +
                        '\n' +
                        'An oven-baked ratatouille can be served with eggs, grilled meat, or with tinned beans stirred in. You could also serve it with jacket potatoes or pasta for a more substantial meal.\n' +
                        '\n' +
                        'Should I go out to buy food?\n' +
                        'Don’t go out to buy food if you can avoid it.\n' +
                        '\n' +
                        'If you need food supplies, you could ask a friend or family member to shop for you and drop the shopping off. Or try online shopping. When you place your order, there will be a place for delivery instructions, where you can write if you need the food dropped off on the doorstep.\n' +
                        '\n' +
                        'Some supermarkets are giving older and vulnerable customers priority for online deliveries. Some are also providing separate opening times for older shoppers – check online for details of your local store.\n' +
                        '\n' +
                        'Community groups have also been set up across the UK to help with things like getting food in for people who are self-isolating, older people or those with long-term conditions.\n' +
                        '\n' +
                        'See the list of groups on Covid Mutual Aid.\n' +
                        'There may not be a group near you, but this list is increasing all the time.\n' +
                        '\n' +
                        'You could also check your local newspaper, or local newspaper’s website, for information on where to get community support.\n' +
                        '\n' +
                        'See more information on what you can and can’t do if you’re shielding, self-isolating, or social distancing.\n' +
                        'Can I go out for a walk?\n' +
                        'Exercise will help boost your immune system and your mood and help you to avoid putting on weight while you\'re at home. It can also help you manage your heart condition, feel more able to do everyday activities, and reduce your risk of future heart attacks and strokes. \n' +
                        '\n' +
                        'The latest government guidance is that during lock-down people can go out of the house to exercise once a day. A daily walk or jog will mean you get some fresh air and a change of scene. Try to stay at least two metres (six feet) away from people.\n' +
                        '\n' +
                        'You can also exercise indoors.',
                }]

            }
        }
    }
</script>
