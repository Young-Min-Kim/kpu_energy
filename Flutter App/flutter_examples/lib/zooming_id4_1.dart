/// Package imports
import 'package:flutter/material.dart';

/// Chart import
import 'package:syncfusion_flutter_charts/charts.dart';

/// db_connect
import 'package:mysql1/mysql1.dart' as mysql;

/// Local imports
import '../../../../../../model/sample_view.dart';
import '../../../../../../model/mysql.dart';
import '../../../../../../model/product.dart';

/// Renders the chart with custom zooming buttons sample.
class ButtonZooming4_1 extends SampleView {
  /// Creates the chart with custom zooming buttons.
  const ButtonZooming4_1(Key key) : super(key: key);

  @override
  _ButtonZooming4_1State createState() => _ButtonZooming4_1State();
}

/// State class of the chart with custom zooming buttons.
class _ButtonZooming4_1State extends SampleViewState {
  _ButtonZooming4_1State();
  late ZoomPanBehavior _zoomPan;

  var db = Mysql();
  List<ProductSmartPlug1> productSmartPlugList = [];
  void _getSmartPlug() {
    // getConnection() -> future�� �񵿱�� �����ϰڴٶ�� ��
    // _getSmartPlug  ������ -> ������ ����
    db.getConnection().then((conn) {
      String sql =
          "select date_format(datetime, '%Y-%m-%d') DateTime, round(sum(amp), 2) amp from db.Smart_plug where id NOT IN (111) and id=4 and date_format(datetime, '%Y-%m-%d') is not null and datetime NOT IN ('2020-11-01 00:00:00') group by date_format(db.Smart_plug.datetime, '%Y-%m-%d')";

      conn.query(sql).then((results) {
        for (var column in results) {
          setState(() {
   
            ProductSmartPlug1 productSmartPlug1 =
                ProductSmartPlug1(column[0], column[1]);

            productSmartPlugList.add(productSmartPlug1);
          });
        }
        print("queryResult1 " + productSmartPlugList.length.toString());

        print("queryResult3 " + productSmartPlugList.length.toString());
      });
    });
  }

  @override
  void initState() {
    _zoomPan = ZoomPanBehavior(
      // ���� ����
      enableDoubleTapZooming: true,
      enablePanning: true,
      enablePinching: true,
      enableSelectionZooming: true,
    );
    super.initState();

    _getSmartPlug();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: model.cardThemeColor,
        body: Padding(
          padding: EdgeInsets.fromLTRB(5, 0, 5, isCardView ? 0 : 50),
          child: Container(child: _buildButtonZoomingChart()),
        ),
        floatingActionButton: isCardView
            ? null
            : Container(
                child: Stack(children: <Widget>[
                  Align(
                    alignment: Alignment.bottomCenter,
                    child: Container(
                      height: 50, // ��ư ��ġ ����
                      child: InkWell(
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: <Widget>[
                            Container(
                              width: model.isWebFullView
                                  ? null
                                  : (MediaQuery.of(context).size.width / 7) *
                                      0.9,
                              padding: const EdgeInsets.fromLTRB(24, 15, 0, 0),
                              child: Tooltip(
                                // Plus
                                message: '�� ��',
                                child: IconButton(
                                  icon: Icon(Icons.add,
                                      color: model.backgroundColor),
                                  onPressed: () {
                                    _zoomPan.zoomIn();
                                  },
                                ),
                              ),
                            ),
                            Container(
                              width: model.isWebFullView
                                  ? null
                                  : (MediaQuery.of(context).size.width / 7) *
                                      0.9,
                              padding: const EdgeInsets.fromLTRB(20, 15, 0, 0),
                              child: Tooltip(
                                message: '�� �ƿ�',
                                child: IconButton(
                                  icon: Icon(Icons.remove,
                                      color: model.backgroundColor),
                                  onPressed: () {
                                    _zoomPan.zoomOut();
                                  },
                                ),
                              ),
                            ),
                            Container(
                              width: model.isWebFullView
                                  ? null
                                  : (MediaQuery.of(context).size.width / 7) *
                                      0.9,
                              padding: const EdgeInsets.fromLTRB(20, 15, 0, 0),
                              child: Tooltip(
                                message: '���� �̵�',
                                child: IconButton(
                                  icon: Icon(Icons.keyboard_arrow_up,
                                      color: model.backgroundColor),
                                  onPressed: () {
                                    _zoomPan.panToDirection('top');
                                  },
                                ),
                              ),
                            ),
                            Container(
                              width: model.isWebFullView
                                  ? null
                                  : (MediaQuery.of(context).size.width / 7) *
                                      0.9,
                              padding: const EdgeInsets.fromLTRB(20, 15, 0, 0),
                              child: Tooltip(
                                message: '�Ʒ��� �̵�',
                                child: IconButton(
                                  icon: Icon(Icons.keyboard_arrow_down,
                                      color: model.backgroundColor),
                                  onPressed: () {
                                    _zoomPan.panToDirection('bottom');
                                  },
                                ),
                              ),
                            ),
                            Container(
                              width: model.isWebFullView
                                  ? null
                                  : (MediaQuery.of(context).size.width / 7) *
                                      0.9,
                              padding: const EdgeInsets.fromLTRB(20, 15, 0, 0),
                              child: Tooltip(
                                message: '���� �̵�',
                                child: IconButton(
                                  icon: Icon(Icons.keyboard_arrow_left,
                                      color: model.backgroundColor),
                                  onPressed: () {
                                    _zoomPan.panToDirection('left');
                                  },
                                ),
                              ),
                            ),
                            Container(
                              width: model.isWebFullView
                                  ? null
                                  : (MediaQuery.of(context).size.width / 7) *
                                      0.9,
                              padding: const EdgeInsets.fromLTRB(20, 15, 0, 0),
                              child: Tooltip(
                                message: '������ �̵�',
                                child: IconButton(
                                  icon: Icon(Icons.keyboard_arrow_right,
                                      color: model.backgroundColor),
                                  onPressed: () {
                                    _zoomPan.panToDirection('right');
                                  },
                                ),
                              ),
                            ),
                            Container(
                              width: model.isWebFullView
                                  ? null
                                  : (MediaQuery.of(context).size.width / 7) *
                                      0.9,
                              padding: const EdgeInsets.fromLTRB(20, 15, 0, 0),
                              child: Tooltip(
                                message: '�ǵ�����',
                                child: IconButton(
                                  icon: Icon(Icons.refresh,
                                      color: model.backgroundColor),
                                  onPressed: () {
                                    _zoomPan.reset();
                                  },
                                ),
                              ),
                            )
                          ],
                        ),
                      ),
                    ),
                  )
                ]),
              ));
  }

  /// Returns the Cartesian chart with custom zooming buttons.
  SfCartesianChart _buildButtonZoomingChart() {
    return SfCartesianChart(
      plotAreaBorderWidth: 0,
      primaryXAxis:
          DateTimeAxis(majorGridLines: const MajorGridLines(width: 0)),
      primaryYAxis: NumericAxis(
          axisLine: const AxisLine(width: 0),
          majorTickLines: const MajorTickLines(size: 0)),
      series: getButtonZoomingSeries(isCardView),
      zoomPanBehavior: _zoomPan,
    );
  }

  List<ChartSampleData> getDateTimeData() {
    // splineSeriesData�갡 ������ �ʱ�ȭ �ѹ� �Ǿ���� �Ʒ��ִ� build�� ����.
    // �� [] �� ��ȣ �ȿ� �̷��� ������ ��Ҹ� ���� �� �ִ� �� ���� for���� �����ϴٴ� ���� ���� ����.
    List<ChartSampleData> splineSeriesData = <ChartSampleData>[
      for (var i = 0; i < productSmartPlugList.length; i++)
        ChartSampleData(
            x: DateTime.parse(
                productSmartPlugList[i].datetime!), // !�� null�� �ƴ϶�� Ȯ���� �ִ� ��
            y: productSmartPlugList[i].amp),
    ];
    print("queryResult2 " + productSmartPlugList.length.toString());

    return splineSeriesData;
  }

  /// Returns the list of chart series which need to render
  /// on the chart with custom zooming buttons.
  List<LineSeries<ChartSampleData, DateTime>> getButtonZoomingSeries(
      bool isTileView) {
    return <LineSeries<ChartSampleData, DateTime>>[
      LineSeries<ChartSampleData, DateTime>(
          dataSource: getDateTimeData(),
          xValueMapper: (ChartSampleData sales, _) => sales.x as DateTime,
          yValueMapper: (ChartSampleData sales, _) => sales.y,
          width: 2)
    ];
  }
}
