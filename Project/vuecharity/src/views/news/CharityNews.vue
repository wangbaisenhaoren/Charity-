<template xmlns:text-align="">
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
          title: 'NHS urges public to get care when they need it',
          date: '2020-04-25',
          contents:'\n'+
                  'NHS chief executive Sir Simon Stevens warned that delays in getting treatment due to coronavirus fears pose a long term risk to people’s health.\n' +
                  '\n' +
                  'Seeking medical help is one of the four reasons that people can safely leave home, in line with government guidance.\n' +
                  '\n' +
                  'And Sir Simon stressed that the NHS is still there for patients without coronavirus who need urgent and emergency services for stroke, heart attack, and other killer conditions.\n' +
                  '\n' +
                  'While NHS staff have worked hard to out in place measures allowing people to access care safely – such as splitting services into Covid and non-Covid – attendances at Accident and Emergency departments are so far on course to be one million lower this April than last.\n' +
                  '\n' +
                  'Some leading clinicians including the Royal College of Paediatrics and Child Health and medical research charities such as us and Stroke Association have expressed concerns that people are risking their long-term health, and their lives, by delaying getting the help they need.',

        }, {
          title: 'BHF-NIHR partnership set to fast-track COVID-19 research',
          date: '2020-04-24',
          contents: 'We have joined forces with the National Institute of Health research (NIHR) to launch a nationwide research initiative to better understand why people with heart and circulatory diseases are at higher risk and often suffer more severely with Covid-19.\n' +
                  '\n' +
                  'Person in lab\n' +
                  '\n' +
                  'The initiative, which builds on an existing partnership between our organisations, will provide a new framework for the rapid set-up and delivery of urgent, high impact Covid-19 research projects across the UK.\n' +
                  '\n' +
                  'With support from the British Cardiovascular Society, the BHF Data Science Centre and Health Data Research UK, we are now calling for applications to establish flagship projects.\n' +
                  '\n' +
                  'Unmet need\n' +
                  'People with heart and circulatory diseases are more likely to develop severe Covid-19 infections, and last week data from the Office of National Statistics (ONS) showed that ischemic heart disease was the most common pre-existing health condition in people who died with Covid-19 during March in England and Wales.\n' +
                  '\n' +
                  'The framework aims to galvanise the UK’s leading cardiovascular researchers and create a streamlined, coordinated, UK-wide approach to research projects to fast-track advances in our understanding of Covid-19.',
        }, {
          title: 'Our Chief Executive: Putting our patients first',
          date: '2020-04-23',
          contents: 'At the very heart of the British Heart Foundation are the 7.4 million people living with heart and circulatory diseases in the UK. They are the reason for everything we do, from funding life saving research, to working with patients and the public to provide better health and care.  \n' +
                  '\n' +
                  'During these turbulent times, it is more important than ever that we put patients, and their needs, first - especially as information to date suggests those with heart and circulatory conditions are at increased risk of severe illness if they develop Covid-19.\n' +
                  '\n' +
                  'That is why we have launched our Patients First programme - the BHF’s number one organisational priority in response to the pandemic. ',
        }, {
          title: 'BHF Professor builds enhanced data resource for Covid-19 research',
          date: '2020-04-20',
          contents: 'A rich source of data \n' +
                  'UK Biobank is a large data set consisting of the health, lifestyle and genetic information of around half a million people in the UK.  This project was originally funded by the Government through the MRC and the Wellcome Trust. Since its beginnings in 2006, UK Biobank has received millions of pounds of funding from the BHF to enhance the resource for researchers studying heart and circulatory diseases. The BHF is now a core funder.\n' +
                  '\n' +
                  'Public Health England are now providing UK Biobank with new Covid-19 related data on study participants, including those with confirmed infection. The team led by Sir Rory Collins, BHF Professor of Medicine and Epidemiology at the University Oxford and Chief Executive of UK Biobank, are building the enhanced data resource for exploration by 15,000 approved researchers in 85 countries around the world.\n' +
                  '\n' +
                  'Unlocking clues\n' +
                  'The hope is that by using this data resource, researchers will better understand the symptoms of coronavirus and why severity can vary significantly between individuals. They will also be able to explore the impact of different diseases and medications on patient outcome and gather comprehensive information on the course of the virus over time.  ',
        }]

      }
    }
  }
</script>
