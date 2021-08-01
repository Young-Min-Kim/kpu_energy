/// Package import
import 'package:flutter/material.dart';

/// Chart import
import 'package:syncfusion_flutter_charts/charts.dart';

/// Local imports
import '../../../../model/sample_view.dart';

// dbb_connect
import 'package:mysql1/mysql1.dart' as mysql;

/// Renders the doughnut chart with legend
class LegendDefault extends SampleView {
  /// Creates the doughnut chart with legend
  const LegendDefault(Key key) : super(key: key);

  @override
  _LegendDefaultState createState() => _LegendDefaultState();
}

class _LegendDefaultState extends SampleViewState {


  _LegendDefaultState();



  @override
  Widget build(BuildContext context) {
    return _buildLegendDefaultChart();
  }

  ///Get the default circular series with legend
  SfCircularChart _buildLegendDefaultChart() {
    return SfCircularChart(
      title: ChartTitle(text: isCardView ? '' : 'Electricity sectors'),
      legend:
          Legend(isVisible: true, overflowMode: LegendItemOverflowMode.wrap),
      series: _getLegendDefaultSeries(),
      tooltipBehavior: TooltipBehavior(enable: true),
    );

  }



  // set managedInfo(List<mysql.ResultRow> managedInfo) {
  //
  // }




  ///Get the default circular series
  List<DoughnutSeries<ChartSampleData, String>> _getLegendDefaultSeries() {

    final List<ChartSampleData> chartData = <ChartSampleData>[



      ChartSampleData(x: 'Coal', y: 30.2),
      ChartSampleData(x: 'Large Hydro', y: 12.7),
      ChartSampleData(x: 'Small Hydro', y: 1.3),
      ChartSampleData(x: 'Wind Power', y: 10),
      ChartSampleData(x: 'Solar Power', y: 8),
      ChartSampleData(x: 'Biomass', y: 2.6),
      ChartSampleData(x: 'Nuclear', y: 1.9),
      ChartSampleData(x: 'Gas', y: 7),
      ChartSampleData(x: 'Diesel', y: 0.2)
    ];
    return <DoughnutSeries<ChartSampleData, String>>[
      DoughnutSeries<ChartSampleData, String>(
          dataSource: chartData,
          xValueMapper: (ChartSampleData data, _) => data.x as String,
          yValueMapper: (ChartSampleData data, _) => data.y,
          startAngle: 90,
          endAngle: 90,
          dataLabelSettings: const DataLabelSettings(
              isVisible: true, labelPosition: ChartDataLabelPosition.outside)),
    ];

  }
  // Future Database() async {
  //   var settings = mysql.ConnectionSettings(
  //       host: '13.209.100.19', user: 'kym', password: 'kim', db: 'db');
  //   var conn = await mysql.MySqlConnection.connect(settings);
  //   var result = await conn.query('select * from Product');
  //   await conn.close();
  //   setState(() {
  //     managedInfo = result.toList();
  //     //https://www.youtube.com/watch?v=ig6WRq73iEg 로 시도해보기
  //   });
  // }
  //
  // @override
  // void initState() {
  //   super.initState();
  //   Database();
  // }


}
